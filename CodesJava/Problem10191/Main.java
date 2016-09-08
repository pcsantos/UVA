import java.util.*;
import java.io.*;

class Main {

    private static final int SIZE = 2;
    private static ArrayList<Schedule> schedule = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int appNumber;
        int j = 1;
        while ((in = input.readLine()) != null) {
            appNumber = Integer.parseInt(in);
            for (int i = 0; i < appNumber; i++) {
                in = input.readLine();
                Schedule s = new Schedule(in);
                schedule.add(s);
            }
            if (appNumber == 0)
                System.out.format("Day #%d: the longest nap starts at 10:00 and will last for 8 hours and 0 minutes.\n", j);
            else {
                Collections.sort(schedule);
                Nap nap = process();
                if ((nap.getDuration() / 60) >= 1) {
                    System.out.format("Day #%d: the longest nap starts at %d:%02d and will last for %d hours and %d minutes.\n", 
                                    j, nap.getStartH(), nap.getStartM(), (nap.getDuration() / 60),(nap.getDuration() % 60));
                } else {
                    System.out.format("Day #%d: the longest nap starts at %d:%02d and will last for %d minutes.\n", 
                                    j, nap.getStartH(), nap.getStartM(), (nap.getDuration() % 60));
                }
            }
            j++;
            schedule.clear();
        }
        input.close();
    }
    
    private static Nap process() {
        int[] aux = {10, 0};
        int[] start;
        int[] end;
        int time = 0;
        int taux;
        Nap nap = null;
        for (Schedule s : schedule) {
            start = s.getStart();
            end = s.getEnd();
            if (smaller(aux, start)) {
                taux = diff(aux, start);
                if (time < taux) {
                    time = taux;
                    nap = new Nap(aux[0], aux[1], time);
                }
            }
            aux[0] = end[0];
            aux[1] = end[1];
        }
        aux[0] = 18;
        aux[1] = 0;
        Schedule s = schedule.get(schedule.size() - 1);
        end = s.getEnd();
        if (smaller(end, aux)) {
            taux = diff(end, aux);
            if (time < taux) {
                nap = new Nap(end[0], end[1], taux);
                return nap;
            }
        }
        return nap;
    }

    private static int diff(int[] t1, int[] t2) {
        return (t2[0] - t1[0]) * 60 + (t2[1] - t1[1]);   
    }
    
    private static boolean smaller(int[] t1, int[] t2) {
        if (t1[0] < t2[0])
            return true;
        if (t1[1] < t2[1])
            return true;
        return false;
    }
    
    static class Nap {
        private int startH;
        private int startM;
        private int duration;

        Nap(int sH, int sM, int dM) {
            this.startH = sH;
            this.startM = sM;
            this.duration = dM;
        }

        int getStartH() {
            return this.startH;
        }

        int getStartM() {
            return this.startM;
        }

        int getDuration() {
            return this.duration;
        }
    }

    static class Schedule implements Comparable<Schedule> {
        private int[] start;
        private int[] end;

        Schedule(String in) {
            StringTokenizer st = new StringTokenizer(in);
            start = setTime(st.nextToken());
            end = setTime(st.nextToken());
        }

        int[] setTime(String t) {
            StringTokenizer st = new StringTokenizer(t, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int[] time = new int[SIZE];
            time[0] = hour;
            time[1] = min;
            return time;
        }
        
        int[] getStart() {
            return start;
        }

        int[] getEnd() {
            return end;
        }

        public int compareTo(Schedule another) {
            if (this.start[0] > another.getStart()[0])
                return 1;
            if (this.start[0] < another.getStart()[0])
                return -1;
            return 0;
        }
    }
}
