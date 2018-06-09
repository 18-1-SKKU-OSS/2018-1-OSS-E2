import java.util.Random;
import java.util.Scanner;

/**
 * For detailed info and implementation see: <a href="http://devmag.org.za/2009/04/25/perlin-noise/">Perlin-Noise</a>
 * �� �� �ڼ��� ������ ���� ������ ���� <a href="http://devmag.org.za/2009/04/25/perlin-noise/">Perlin-Noise</a> �� �����Ͻʽÿ�
 * Perlin Noise �� �ڿ����� ������ ���� ������ ���� �����ϴ� �˰��� �Դϴ�. 
 */
public class PerlinNoise {
    /**
     * @param width width of noise array
     * @param height height of noise array
     * @param octaveCount numbers of layers used for blending noise
     * @param persistence value of impact each layer get while blending
     * @param seed used for randomizer
     * @return float array containing calculated "Perlin-Noise" values
     * 
     * width ��� ������ ����� ���� �迭�Դϴ�. 
     * height ��� ������ ������ �迭�� ���� �Դϴ�. 
     * octaveCount ����� ���� ���� �����Դϴ�.
     * persistence�� ���� �� �� ���� �޴� ����Ʈ�� ���Դϴ�.
     * seed��� ������ ����ȭ�� ���� ���Դϴ�.
     * float�� Perlin-Noise ���� ���� �迭�� �����մϴ�.
     */
    static float[][] generatePerlinNoise(int width, int height, int octaveCount, float persistence, long seed) {
        final float[][] base = new float[width][height];
        final float[][] perlinNoise = new float[width][height];
        final float[][][] noiseLayers = new float[octaveCount][][];

        Random random = new Random(seed);
        //fill base array with random values as base for noise
        //�迭�� �������� ���ʰ� �� ������ ������ ä��ϴ�. 
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                base[x][y] = random.nextFloat();
            }
        }

        //calculate octaves with different roughness
        //octave�� ���δٸ� ��ħ�� ������ ����մϴ�. 
        for(int octave = 0; octave < octaveCount; octave++) {
            noiseLayers[octave] = generatePerlinNoiseLayer(base, width, height, octave);
        }

        float amplitude = 1f;
        float totalAmplitude = 0f;

        //calculate perlin noise by blending each layer together with specific persistence
        //�� ���� ���� �ٸ� persistence�� ���������ν� perlin noise�� ����մϴ�. 
        for(int octave = octaveCount - 1; octave >= 0; octave--) {
            amplitude *= persistence;
            totalAmplitude += amplitude;

            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    //adding each value of the noise layer to the noise
                    //by increasing amplitude the rougher noises will have more impact
                	//������ ���l ���� ����� ���մϴ�. 
                	//������ ������Ŵ���ν� ������� �� ���� ����Ʈ�� �����ϴ�. 
                    perlinNoise[x][y] += noiseLayers[octave][x][y] * amplitude;
                }
            }
        }

        //normalize values so that they stay between 0..1 ������ ����ȭ���� 0�� 1���̿� �ֵ��� �մϴ�. 
        for(int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                perlinNoise[x][y] /= totalAmplitude;
            }
        }

        return perlinNoise;
    }

    /**
     * @param base base random float array
     * @param width width of noise array
     * @param height height of noise array
     * @param octave current layer
     * @return float array containing calculated "Perlin-Noise-Layer" values
     * 
     * base��� ������ ������ float�� ���� ���� �迭�Դϴ�.
     * width��� ������ ������ �迭�� �β��Դϴ�. 
     * height��� ������ ������ �迭�� �����Դϴ�. 
     * octave��� ������ ������ ���� ���Դϴ�. 
     * ���� float���� perlin-noise-layer�� ����ִ� �迭�� �����մϴ�. 
     */
    static float[][] generatePerlinNoiseLayer(float[][] base, int width, int height, int octave) {
        float[][] perlinNoiseLayer = new float[width][height];

        //calculate period (wavelength) for different shapes
        //�ΰ��� �ٸ� ����� �ֱ⸦ ����մϴ�. 
        int period = 1 << octave; //2^k
        float frequency = 1f / period; // 1/2^k

        for(int x = 0; x < width; x++) {
            //calculates the horizontal sampling indices
        	//������ ���ø��� �ε��� ���� ����մϴ�. 
            int x0 = (x / period) * period;
            int x1 = (x0 + period) % width;
            float horizintalBlend = (x - x0) * frequency;

            for(int y = 0; y < height; y++) {
                //calculates the vertical sampling indices
            	//������ ���ø��� �ε��� ���� ����մϴ�. 
                int y0 = (y / period) * period;
                int y1 = (y0 + period) % height;
                float verticalBlend = (y - y0) * frequency;

                //blend top corners
                //�� �����ڸ��� �����ϴ�. 
                float top = interpolate(base[x0][y0], base[x1][y0], horizintalBlend);

                //blend bottom corners
                //�Ʒ� �����ڸ��� �����ϴ�. 
                float bottom = interpolate(base[x0][y1], base[x1][y1], horizintalBlend);

                //blend top and bottom interpolation to get the final blend value for this cell
                //���� �Ʒ��� ���������� ä���ְ�, �ش��ϴ� ��ġ�� ���� ���� ����ϴ�. 
                perlinNoiseLayer[x][y] = interpolate(top, bottom, verticalBlend);
            }
        }

        return perlinNoiseLayer;
    }

    /**
     * @param a value of point a
     * @param b value of point b
     * @param alpha determine which value has more impact (closer to 0 -> a, closer to 1 -> b)
     * @return interpolated value
     * 
     * a��� ������ a���� ���Դϴ�.
     * b��� ������ b���� ���Դϴ�. 
     * alpha��� ������ � ���� �� ū ����Ʈ�� �������� �����մϴ�. 
     * �������� ������ ���� �����մϴ�. 
     */
    static float interpolate(float a, float b, float alpha) {
        return a * (1 - alpha) + alpha * b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int width;
        final int height;
        final int octaveCount;
        final float persistence;
        final long seed;
        final String charset;
        final float[][] perlinNoise;

        System.out.println("Width (int): ");
        width = in.nextInt();

        System.out.println("Height (int): ");
        height = in.nextInt();

        System.out.println("Octave count (int): ");
        octaveCount = in.nextInt();

        System.out.println("Persistence (float): ");
        persistence = in.nextFloat();

        System.out.println("Seed (long): ");
        seed = in.nextLong();

        System.out.println("Charset (String): ");
        charset = in.next();


        perlinNoise = generatePerlinNoise(width, height, octaveCount, persistence, seed);
        final char[] chars = charset.toCharArray();
        final int length = chars.length;
        final float step = 1f / length;
        //output based on charset  charset�� �ٰ��� ���
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                float value = step;
                float noiseValue = perlinNoise[x][y];

                for (char c : chars) {
                    if (noiseValue <= value) {
                        System.out.print(c);
                        break;
                    }

                    value += step;
                }
            }

            System.out.println();
        }
    }
}
