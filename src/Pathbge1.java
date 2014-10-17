import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pathbge1 {
    FastScanner in;
    PrintWriter out;
    Queue<Integer> queue;
    ArrayList<Integer>[] graph;
    boolean[] color;
    int[] d;

    public static void main(String[] arg) {
        new Pathbge1().run();
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList[n];
        queue = new PriorityQueue<Integer>();
        color = new boolean[n];
        d = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
            color[i] = false;
            d[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int t1 = in.nextInt() - 1;
            int t2 = in.nextInt() - 1;
            graph[t1].add(t2);
            graph[t2].add(t1);
        }
        int s = 0;
        queue.add(s);
        color[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.peek();
            queue.remove();
            for (int i = 0; i < graph[v].size(); i++) {
                int to = graph[v].get(i);
                if (!color[to]) {
                    color[to] = true;
                    queue.add(to);
                    d[to] = d[v] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(d[i] + " ");
        }

    }

    public void run() {
        try {
            in = new FastScanner(new File("pathbge1.in"));
            out = new PrintWriter(new File("pathbge1.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Pair {
        int v1;
        int v2;

        Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }


    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}