import java.util.Random;
import java.util.Scanner;

/**
 * For detailed info and implementation see: <a href="http://devmag.org.za/2009/04/25/perlin-noise/">Perlin-Noise</a>
 * 좀 더 자세한 구현을 보고 싶은신 분은 <a href="http://devmag.org.za/2009/04/25/perlin-noise/">Perlin-Noise</a> 를 참고하십시오
 * Perlin Noise 란 자연적인 질서를 가진 임의의 값을 생성하는 알고리즘 입니다. 
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
     * width 라는 변수는 노이즈를 입힐 배열입니다. 
     * height 라는 변수는 노이즈 배열의 높이 입니다. 
     * octaveCount 노이즈를 섞을 층의 갯수입니다.
     * persistence는 섞을 때 각 층이 받는 임팩트의 값입니다.
     * seed라는 변수는 랜덤화를 위해 쓰입니다.
     * float형 Perlin-Noise 값을 담은 배열을 리턴합니다.
     */
    static float[][] generatePerlinNoise(int width, int height, int octaveCount, float persistence, long seed) {
        final float[][] base = new float[width][height];
        final float[][] perlinNoise = new float[width][height];
        final float[][][] noiseLayers = new float[octaveCount][][];

        Random random = new Random(seed);
        //fill base array with random values as base for noise
        //배열을 노이즈의 기초가 될 랜덤한 갓으로 채웁니다. 
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                base[x][y] = random.nextFloat();
            }
        }

        //calculate octaves with different roughness
        //octave를 서로다른 거침의 정도로 계산합니다. 
        for(int octave = 0; octave < octaveCount; octave++) {
            noiseLayers[octave] = generatePerlinNoiseLayer(base, width, height, octave);
        }

        float amplitude = 1f;
        float totalAmplitude = 0f;

        //calculate perlin noise by blending each layer together with specific persistence
        //각 층을 서로 다른 persistence로 섞어줌으로써 perlin noise를 계산합니다. 
        for(int octave = octaveCount - 1; octave >= 0; octave--) {
            amplitude *= persistence;
            totalAmplitude += amplitude;

            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    //adding each value of the noise layer to the noise
                    //by increasing amplitude the rougher noises will have more impact
                	//노이츠 층릐 값을 노이즈에 더합니다. 
                	//진폭을 증가시킴으로써 노이즈는 더 강한 임팩트를 가집니다. 
                    perlinNoise[x][y] += noiseLayers[octave][x][y] * amplitude;
                }
            }
        }

        //normalize values so that they stay between 0..1 값들을 정규화시켜 0과 1사이에 있도록 합니다. 
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
     * base라는 변수는 랜덤한 float형 수를 담은 배열입니다.
     * width라는 변수는 노이즈 배열의 두께입니다. 
     * height라는 변수는 노이즈 배열의 높이입니다. 
     * octave라는 변수는 현재의 층의 값입니다. 
     * 계산된 float형의 perlin-noise-layer를 담고있는 배열을 리턴합니다. 
     */
    static float[][] generatePerlinNoiseLayer(float[][] base, int width, int height, int octave) {
        float[][] perlinNoiseLayer = new float[width][height];

        //calculate period (wavelength) for different shapes
        //두개의 다른 모양의 주기를 계산합니다. 
        int period = 1 << octave; //2^k
        float frequency = 1f / period; // 1/2^k

        for(int x = 0; x < width; x++) {
            //calculates the horizontal sampling indices
        	//수평적 샘플링의 인덱스 값을 계산합니다. 
            int x0 = (x / period) * period;
            int x1 = (x0 + period) % width;
            float horizintalBlend = (x - x0) * frequency;

            for(int y = 0; y < height; y++) {
                //calculates the vertical sampling indices
            	//수직적 샘플링의 인덱스 값을 계산합니다. 
                int y0 = (y / period) * period;
                int y1 = (y0 + period) % height;
                float verticalBlend = (y - y0) * frequency;

                //blend top corners
                //위 가장자리를 섞습니다. 
                float top = interpolate(base[x0][y0], base[x1][y0], horizintalBlend);

                //blend bottom corners
                //아랫 가장자리를 섞습니다. 
                float bottom = interpolate(base[x0][y1], base[x1][y1], horizintalBlend);

                //blend top and bottom interpolation to get the final blend value for this cell
                //위와 아래를 보간법으로 채워주고, 해당하는 위치의 최종 값을 얻습니다. 
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
     * a라는 변수는 a점의 값입니다.
     * b라는 변수는 b점의 값입니다. 
     * alpha라는 변수는 어떤 값이 더 큰 임팩트를 가지는지 결정합니다. 
     * 보간법을 적용한 값을 리턴합니다. 
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
        //output based on charset  charset에 근거한 결과
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
