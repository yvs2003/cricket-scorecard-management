package com.company;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Random;
import java.io.File;


class take_variables {
    Scanner a = new Scanner(System.in);
    static String teamm1 = "";
    static String teamm2 = "";

    static int bat[] = new int[11];
    static int ball[] = new int[11];
    static int four[] = new int[11];
    static int six[] = new int[11];

    static int run2 = 0;
    static int p = 0, q = 1;
    static int c = 0;
    static int total = 0;
    static char run;
    static int over;
    static int wicket1 = 0, wicket2 = 0;

    static int bat2[] = new int[11];
    static int ball2[] = new int[11];
    static int four2[] = new int[11];
    static int six2[] = new int[11];

    static int runp = 0;
    static int p2 = 0, q2 = 1;
    static int c2 = 0;
    static int total2 = 0;
    static char runn;
}

public class Ccc extends take_variables {
    public static void main(String args[]) throws FileNotFoundException {
        FileWriter Obj = null;
        try {
            Obj = new FileWriter("myfile.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\t\t\t\t\t\t\t CRICKET SCORECARD MANAGEMENT\n");

        System.out.println("Press 1 to play in India");
        System.out.println("Press 2 to play in England");
        System.out.println("Press 3 to play in Australia");
        System.out.println("Press 4 to play in South Africa");
        System.out.println("Press 5 to play in New Zealand");
        System.out.println("Press 6 to play in West Indies");
        System.out.println(
                "Press 7 to play in Pakistan (only in emergency circumstances) , otherwise other venues are available, play there.\n");

        int x;
        System.out.println("Enter your choice for venue : ");
        Scanner ven = new Scanner(System.in);
        x = ven.nextInt();
        switch (x) {
            case 1:
                System.out.println("\nVenue for the match: India\n");
                break;
            case 2:
                System.out.println("\nVenue for the match: England\n");
                break;
            case 3:
                System.out.println("\nVenue for the match: Australia\n");
                break;
            case 4:
                System.out.println("\nVenue for the match: South Africa \n");
                break;
            case 5:
                System.out.println("\nVenue for the match: New Zealand \n");
                break;
            case 6:
                System.out.println("\nVenue for the match: West Indies\n");
                break;
            case 7:
                System.out.println("\nVenue for the match: Pakistan\n");
                break;

        }

        System.out.println("\nGet ready for an exciting cricket match: \n");
        System.out.println("\nHere are the rules for the match: \n");
        System.out.println("Press 1 to take one run:");
        System.out.println("Press 2 to take two runs:");
        System.out.println("Press 3 to take three run:");
        System.out.println("Press 5 to take five  runs:");
        System.out.println("Press 4 to hit a four:");
        System.out.println("Press 6 to hit a six:");
        System.out.println("Press w for a wide ball:");
        System.out.println("Press n for a no ball:");
        System.out.println("Press b if a wicket goes down:\n\n\n");

        Scanner scm = new Scanner(System.in);
        String team1 = "";
        String team2 = "";
        System.out.println("Enter name of team 1: ");
        teamm1 = scm.nextLine();
        System.out.println("Enter name of team 2: ");
        teamm2 = scm.nextLine();

        Random rand = new Random();

        int upper = 2;
        int int_random = rand.nextInt(upper);
        System.out.println("Welcome for toss : ");
        System.out.println("Team 1 please take the call either 0 or 1 : ");
        int hem = scm.nextInt();
        if (hem == int_random) {
            System.out.println("You won the toss what will you choose ? bat(1)   ball(2)");
            int t = scm.nextInt();
            if (t == 1) {
                team1 = teamm1;
                team2 = teamm2;
            }
            else {
                team1 = teamm2;
                team2 = teamm1;
            }
        }
        else {
            System.out.println("opponent won the toss what will they choose ? bat(1)   ball(2)");
            int t = scm.nextInt();
            if (t == 1) {
                team1 = teamm2;
                team2 = teamm1;
            } else {
                team1 = teamm1;
                team2 = teamm2;
            }

        }

        System.out.println("Enter Overs");
        over = scm.nextInt();
        for (int i = 0; i < 11; i++) {
            bat[i] = 0;
            ball[i] = 0;
            four[i] = 0;
            six[i] = 0;
        }

        for (int i = 1; i <= 6 * over; i++) {

            if (c == 0) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Batsman " + (p + 1) + " : ");
                run = sc.next().charAt(0);
                if (run == 'b') {

                    wicket1++;
                    ball[p] += 1;
                    if (wicket1 == 10) {

                        System.out.println("Team all out: ");
                        break;
                    }

                    int u = (p > q) ? p : q;
                    p = u + 1;

                }
                if (run == '1')
                    run2 = 1;
                if (run == '2')
                    run2 = 2;
                if (run == '3')
                    run2 = 3;
                if (run == '4')
                    run2 = 4;
                if (run == '5')
                    run2 = 5;
                if (run == '6')
                    run2 = 6;
                if (run == 'w') {
                    total += 1;
                    i--;
                    continue;
                }
                if (run == 'n') {

                    total += 1;
                    i--;
                    continue;
                }
                if (run != 'b') {
                    ball[p] += 1;
                    bat[p] += run2;
                    total += run2;
                }

                if (run2 == 6 && run != 'b')
                    six[p] += 1;
                if (run2 == 4 && run != 'b')
                    four[p] += 1;
                if (i % 6 == 0) {
                    System.out.println("over");
                    if (run % 2 != 0) {
                        c = 0;
                        continue;
                    }
                    System.out.println("Rotating strike ");
                    c = 1;
                    continue;
                }
                if (run2 % 2 != 0 && run != 'b') {
                    System.out.println("Rotating strike ");
                    c = 1;
                    continue;
                }
            }
            if (c == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Batsman " + (q + 1) + " : ");
                run = sc.next().charAt(0);
                if (run == 'b') {
                    wicket1++;
                    ball[q] += 1;
                    if (wicket1 == 10) {

                        System.out.println("Team all out: ");
                        break;
                    }
                    int u = (p > q) ? p : q;
                    q = u + 1;

                }
                if (run == '1')
                    run2 = 1;
                if (run == '2')
                    run2 = 2;
                if (run == '3')
                    run2 = 3;
                if (run == '4')
                    run2 = 4;
                if (run == '5')
                    run2 = 5;
                if (run == '6')
                    run2 = 6;
                if (run == 'w') {
                    total += 1;
                    i--;
                    continue;
                }
                if (run == 'n') {

                    total += 1;
                    i--;
                    continue;
                }
                if (run != 'b') {
                    ball[q] += 1;
                    bat[q] += run2;
                    total += run2;
                }
                if (run2 == 6 && run != 'b')
                    six[q] += 1;
                if (run2 == 4 && run != 'b')
                    four[q] += 1;
                if (i % 6 == 0) {
                    System.out.println("over");
                    if (run % 2 != 0) {
                        c = 1;
                        continue;
                    }
                    System.out.println("Rotating strike ");
                    c = 0;
                    continue;
                }
                if (run2 % 2 != 0 && run != 'b') {
                    System.out.println("Rotating strike ");
                    c = 0;
                    continue;
                }
            }
        }
        System.out.println("\nDisplaying Scorecard of :" + team1);
        System.out.println();
        for (int i = 0; i < 11; i++) {
            System.out.print("Batsmen:" + (i + 1));
            System.out.print(" \truns = " + bat[i]);
            System.out.print(" \tballs = " + ball[i]);
            System.out.print(" \tsixes = " + six[i]);
            System.out.print(" \tfours = " + four[i]);
            if (ball[i] == 0) {
                System.out.print(" \tStrike rate = 0\n\n");
            } else {
                System.out.print(" \tStrike rate = " + (float) bat[i] / ball[i] * 100);
                System.out.print("\n\n");
            }
            try {
                Obj.write("Batsmen:" + (i + 1));
                Obj.write(" \truns = " + bat[i]);
                Obj.write(" \tballs = " + ball[i]);
                Obj.write(" \tsixes = " + six[i]);
                Obj.write(" \tfours = " + four[i]);
                if (ball[i] == 0) {
                    Obj.write(" \tStrike rate = 0\n\n");
                } else {
                    Obj.write(" \tStrike rate = " + (float) bat[i] / ball[i] * 100);
                    Obj.write("\n\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(team1 + " score " + total + " / " + wicket1 + "\n");
        try {
            Obj.write(team1 + " score " + total + " / " + wicket1 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Now " + team2 + " will come to bat ");

        Scanner scc = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            bat2[i] = 0;
            ball2[i] = 0;
            four2[i] = 0;
            six2[i] = 0;
        }
        for (int i = 1; i <= 6 * over; i++) {
            if (total2 > total) {

                break;
            }
            if (c2 == 0) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Batsman " + (p2 + 1) + " : ");
                runn = sc.next().charAt(0);
                if (runn == 'b') {
                    wicket2++;

                    ball2[p2] += 1;

                    if (wicket2 == 10) {
                        System.out.println("Team all out:\n ");
                        break;
                    }

                    int u2 = (p2 > q2) ? p2 : q2;

                    p2 = u2 + 1;

                }
                if (runn == '1')
                    runp = 1;
                if (runn == '2')
                    runp = 2;
                if (runn == '3')
                    runp = 3;
                if (runn == '4')
                    runp = 4;
                if (runn == '5')
                    runp = 5;
                if (runn == '6')
                    runp = 6;
                if (runn == 'w') {
                    total2 += 1;
                    i--;
                    continue;
                }
                if (runn == 'n') {

                    total2 += 1;
                    i--;
                    continue;
                }
                if (runn != 'b') {
                    ball2[p2] += 1;
                    bat2[p2] += runp;
                    total2 += runp;
                }

                if (runp == 6 && runn != 'b')
                    six2[p2] += 1;

                if (runp == 4 && runn != 'b')
                    four2[p2] += 1;

                if (i % 6 == 0) {
                    System.out.println("over");
                    if (runn % 2 != 0) {
                        c2 = 0;
                        continue;
                    }
                    System.out.println("Rotating strike ");
                    c2 = 1;
                    continue;
                }
                if (runp % 2 != 0 && runn != 'b') {
                    System.out.println("Rotating strike ");
                    c2 = 1;
                    continue;
                }
            }
            if (c2 == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Batsman " + (q2 + 1) + " : ");
                runn = sc.next().charAt(0);

                if (runn == 'b') {
                    ball2[q2] += 1;

                    wicket2++;

                    if (wicket2 == 10) {
                        System.out.println("Team all out: \n");
                        break;
                    }

                    int u2 = (p2 > q2) ? p2 : q2;

                    q2 = u2 + 1;

                }
                if (runn == '1')
                    runp = 1;
                if (runn == '2')
                    runp = 2;
                if (runn == '3')
                    runp = 3;
                if (runn == '4')
                    runp = 4;
                if (runn == '5')
                    runp = 5;
                if (runn == '6')
                    runp = 6;
                if (runn == 'w') {
                    total2 += 1;
                    i--;
                    continue;
                }
                if (runn == 'n') {

                    total2 += 1;
                    i--;
                    continue;
                }
                if (runn != 'b') {
                    ball2[q2] += 1;
                    bat2[q2] += runp;
                    total2 += runp;
                }

                if (runp == 6 && runn != 'b')
                    six2[q2] += 1;

                if (runp == 4 && runn != 'b')
                    four2[q2] += 1;

                if (i % 6 == 0) {
                    System.out.println("over");
                    if (runp % 2 != 0) {
                        c2 = 1;
                        continue;
                    }
                    System.out.println("Rotating strike ");
                    c2 = 0;
                    continue;
                }
                if (runp % 2 != 0 && runn != 'b') {
                    System.out.println("Rotating strike ");
                    c2 = 0;
                    continue;
                }
            }

        }
        System.out.println("\nDisplaying Scorecard of :" + team2 + "\n");
        for (int i = 0; i < 11; i++) {

            System.out.print("Batsmen:" + (i + 1));
            System.out.print(" \truns = " + bat2[i]);
            System.out.print(" \tballs = " + ball2[i]);
            System.out.print(" \tsixes = " + six2[i]);
            System.out.print(" \tfours = " + four2[i]);
            if (ball2[i] == 0) {
                System.out.print(" \tStrike rate = 0\n\n");
            } else {
                System.out.print(" \tStrike rate = " + (float) bat2[i] / ball2[i] * 100);
                System.out.print("\n\n");
            }


            try {
                Obj.write("Batsmen:" + (i + 1));
                Obj.write (" \truns = " + bat2[i]);
                Obj.write(" \tballs = " + ball2[i]);
                Obj.write (" \tsixes = " + six2[i]);
                Obj.write(" \tfours = " + four2[i]);
                if (ball2[i] == 0) {
                    Obj.write(" \tStrike rate = 0\n\n");
                } else {
                    Obj.write(" \tStrike rate = " + (float) bat2[i] / ball2[i] * 100);
                    Obj.write("\n\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(team2 + " score " + total2 + " / " + wicket2);
        try {
            Obj.write(team2 + " score " + total2 + " / " + wicket2);
            Obj.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (total > total2) {
            System.out.println("\n" + team1 + " won by " + (total - total2) + " runs");
        }

        else if (total < total2) {
            System.out.println("\n" + team2 + " won by " + (10 - wicket2) + " wickets");
        }

        else {
            System.out.println("\n\nGet ready for a super ball contest untill we get winner of this match : ");
            while (true) {

                int a, b;

                System.out.println(team1 + " score on a super ball");

                a = scc.nextInt();

                System.out.println(team2 + " score on a super ball");

                b = scc.nextInt();

                if (a > b) {
                    System.out.println(team1 + " won the match in a thrilling super ball contest");
                    break;
                }

                else if (a < b) {

                    System.out.println(team2 + " won the match in a thrilling super ball contest");
                    break;

                }

                else {
                    System.out.println("Get ready for another super ball contest : ");
                    continue;
                }

            }
        }
        try {
            Obj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

