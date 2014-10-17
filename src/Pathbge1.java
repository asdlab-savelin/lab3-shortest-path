import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pathbge1 {
    FastScanner in;
    PrintWriter out;
    ArrayList<Integer>[] graph;
    boolean[] color;
    int[] d, p;

    public static void main(String[] arg) {
        new Pathbge1().run();
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList[n];
        color = new boolean[n];
        d = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
            color[i] = false;
            d[i] = 100;
        }
        for (int i = 0; i < m; i++) {
            int t1 = in.nextInt() - 1;
            int t2 = in.nextInt() - 1;
            graph[t1].add(t2);
            graph[t2].add(t1);
        }
        int s = 0;
        d[s] = 0;
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!color[j] && (v == -1 || d[j] < d[v])) {
                    v = j;
                }
            }
            if (d[v] == 100) {
                break;
            }
            color[v] = true;
            for (int j = 0; j < graph[v].size(); j++) {
                int to = graph[v].get(j);
                if (d[v] + 1 < d[to]) {
                    d[to] = d[v] + 1;
                    p[to] = v;
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