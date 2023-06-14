package test;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {

	// public static void main(String[] args) {

	// /* Kick everything off by calling solve() */
	// try {
	// Scanner in = new Scanner(System.in);
	// String dicFile = in.next();
	// String gridFile = in.next();
	// in.close();
	// new WordPuzzleSolver().solve(dicFile, gridFile);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }

	// }
	public static void main(String[] args) {

		/* Kick everything off by calling solve() */
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("Name of dictionary file: ");
			String dicFile = in.next();// "code\\HashTables\\input\\words.txt";//in.next();
			System.out.print("Name of grid file: ");
			String gridFile = in.next();// "code\\HashTables\\input\\3x3.grid.txt"; //in.next();
			in.close();
			new WordPuzzleSolver().solve(dicFile, gridFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {

		/* Implement this method. Open the files and solve the word puzzle!! */
		Scanner scammer = new Scanner(new FileReader(gridFile));
		HashTable<String, String> table = new HashTable<>(75000);
		int rows = scammer.nextInt();
		int cols = scammer.nextInt();
		String vals = scammer.next();
		int idx = 0;
		char[][] grid = new char[rows][cols];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = vals.charAt(idx);
				idx += 1;
			}
		}

		Scanner diScanner = new Scanner(new FileReader(dictFile));
		ArrayList<String> words = new ArrayList<>();
		while (diScanner.hasNext()) {
			String w = diScanner.next();
			table.insert(w, null);
			words.add(w);

		}
		for (String w : words) {
			if (!table.contains(w)) {
				System.out.print(w + " not found in table");
				System.exit(0);
			}
		}
		System.out.println("Elements successfully added");
		// System.exit(0);
		// make sure everything is in there
		PrintWriter pw = new PrintWriter(rows + "x" + cols + ".out.txt");
		// conduct search for words in all eight directions
		int totalWords = 0;
		long start = System.currentTimeMillis();
		for (int r = 0; r < grid.length; r++) {
			// System.out.println(r);
			for (int c = 0; c < grid[0].length; c++) {
				// for (int wordlen = 3; wordlen <= 22; wordlen++) {
				// N (row - 1)
				int wordlen = 22;
				int boundN = Math.max(-1, r - wordlen);
				// if (boundN == r - wordlen) {
				String wordN = "";
				for (int x = r; x > boundN; x--) {
					wordN += grid[x][c];
					if (wordN.length() >= 3 && table.contains(wordN)) {
						pw.println("N" + " (" + r + " ," + c + "): " + wordN);
						totalWords++;
					}
				}

				// }

				// S (row + 1)
				int boundS = Math.min(grid.length, r + wordlen);

				// if (boundS == r + wordlen) {
				String wordS = "";
				for (int x = r; x < boundS; x++) {
					wordS += grid[x][c];
					if (wordS.length() >= 3 && table.contains(wordS)) {
						pw.println("S" + " (" + r + " ," + c + "): " + wordS);
						totalWords++;
					}
				}

				// }

				// W (col -1)

				int boundW = Math.max(-1, c - wordlen);
				// if (boundW == c - wordlen) {
				String wordW = "";
				for (int x = c; x > boundW; x--) {
					wordW += grid[r][x];
					if (wordW.length() >= 3 && table.contains(wordW)) {
						pw.println("W" + " (" + r + " ," + c + "): " + wordW);
						totalWords++;
					}
				}

				// }
				// E (col + 1)
				int boundE = Math.min(grid[0].length, c + wordlen);
				// if (boundE == c + wordlen) {
				String wordE = "";
				for (int x = c; x < boundE; x++) {
					wordE += grid[r][x];
					if (wordE.length() >= 3 && table.contains(wordE)) {
						pw.println("E" + " (" + r + " ," + c + "): " + wordE);
						totalWords++;
					}
				}

				// }
				// NE (row-1, col+1)
				// if (boundN == r - wordlen && boundE == c + wordlen) {
				String wordNE = "";
				int countNE = 0;
				int y = r;
				int x = c;
				while (countNE <= wordlen && y >= 0 && x < grid[0].length) {
					wordNE += grid[y][x];
					y--;
					x++;
					countNE++;
					if (wordNE.length() >= 3 && table.contains(wordNE)) {
						pw.println("NE" + "(" + r + " ," + c + "): " + wordNE);
						totalWords++;
					}
				}

				// }
				// NW (row-1, col - 1)
				// if(boundN ==r-wordlen && boundW==c-wordlen){
				String wordNW = "";
				int count = 0;
				y = r;
				x = c;
				while (count <= wordlen && y > -1 && x > -1) {
					wordNW += grid[y][x];
					y--;
					x--;
					count++;
					if (wordNW.length() >= 3 && table.contains(wordNW)) {
						pw.println("NW" + "(" + r + " ," + c + "): " + wordNW);
						totalWords++;
					}
				}

				// }
				// SW (row + 1, col -1)
				// if(boundS ==r+wordlen && boundW==c-wordlen){
				String wordSW = "";
				count = 0;
				y = r;
				x = c;
				while (count <= wordlen && y < grid.length && x >= 0) {
					wordSW += grid[y][x];
					y++;
					x--;
					count++;
					if (wordSW.length() >= 3 && table.contains(wordSW)) {
						pw.println("SW" + "(" + r + " ," + c + "): " + wordSW);
						totalWords++;
					}
				}

				// }
				// SE (row + 1, col + 1)
				// if(boundS ==r+wordlen && boundE==c+wordlen){
				String wordSE = "";
				count = 0;
				y = r;
				x = c;
				while (count <= wordlen && y < grid.length && x < grid[0].length) {
					wordSE += grid[y][x];
					y++;
					x++;
					count++;
					if (wordSE.length() >= 3 && table.contains(wordSE)) {
						pw.println("SE" + "(" + r + " ," + c + "): " + wordSE);
						totalWords++;
					}
				}
				
			}

		}
		long end = System.currentTimeMillis();
		pw.println(totalWords + " words found");
		pw.println("Found all words in " + ((end - start) * 1.0 / 1000) + " seconds.");
		pw.close();

	}

	// /* Solve the puzzle */
	// private void solve(String dictFile, String gridFile) throws IOException {

	// /* Implement this method. Open the files and solve the word puzzle!! */
	// Scanner scammer = new Scanner(new FileReader(gridFile));
	// HashTable<String, String> table = new HashTable<>(75000);
	// int rows = scammer.nextInt();
	// int cols = scammer.nextInt();
	// String vals = scammer.next();
	// int idx = 0;
	// char[][] grid = new char[rows][cols];
	// for (int i = 0; i < grid.length; i++) {
	// for (int j = 0; j < grid[0].length; j++) {
	// grid[i][j] = vals.charAt(idx);
	// idx += 1;
	// }
	// }

	// Scanner diScanner = new Scanner(new FileReader(dictFile));
	// ArrayList<String> words = new ArrayList<>();
	// while (diScanner.hasNext()) {
	// String w = diScanner.next();
	// table.insert(w, null);
	// words.add(w);

	// }
	// for(String w: words){
	// if(!table.contains(w)){
	// System.out.print(w + " not found in table");
	// System.exit(0);
	// }
	// }
	// System.out.println("Elements successfully added");
	// // System.exit(0);
	// //make sure everything is in there
	// PrintWriter pw = new PrintWriter(rows + "x" + cols + ".out.txt");
	// // conduct search for words in all eight directions
	// int totalWords = 0;
	// long start = System.currentTimeMillis();
	// for (int r = 0; r < grid.length; r++) {
	// //System.out.println(r);
	// for (int c = 0; c < grid[0].length; c++) {
	// for (int wordlen = 3; wordlen <= 22; wordlen++) {
	// // N (row - 1)
	// int boundN = Math.max(-1, r - wordlen);
	// if (boundN == r - wordlen) {
	// String word = "";
	// for (int x = r; x > boundN; x--) {
	// word += grid[x][c];
	// }
	// if (table.contains(word)) {
	// pw.println("N" + " (" + r + " ," + c + "): " + word);
	// totalWords ++;
	// }
	// }

	// // S (row + 1)
	// int boundS = Math.min(grid.length, r + wordlen);

	// if (boundS == r + wordlen) {
	// String word = "";
	// for (int x = r; x < boundS; x++) {
	// word += grid[x][c];
	// }
	// if (table.contains(word)) {
	// pw.println("S" + " (" + r + " ," + c + "): " + word);
	// totalWords ++;
	// }
	// }

	// // W (col -1)

	// int boundW = Math.max(-1, c - wordlen);
	// if (boundW == c - wordlen) {
	// String word = "";
	// for (int x = c; x > boundW; x--) {
	// word += grid[r][x];
	// }
	// if (table.contains(word)) {
	// pw.println("W" + " (" + r + " ," + c + "): " + word);
	// totalWords ++;
	// }
	// }
	// // E (col + 1)
	// int boundE = Math.min(grid[0].length, c + wordlen);
	// if (boundE == c + wordlen) {
	// String word = "";
	// for (int x = c; x < boundE; x++) {
	// word += grid[r][x];
	// }
	// if (table.contains(word)) {
	// pw.println("E" + " (" + r + " ," + c + "): " + word);
	// totalWords ++;
	// }
	// }
	// // NE (row-1, col+1)
	// if (boundN == r - wordlen && boundE == c + wordlen) {
	// String word = "";
	// int count = 0;
	// int y = r;
	// int x = c;
	// while(count < wordlen){
	// word += grid[y][x];
	// y--;
	// x++;
	// count ++;
	// }
	// if (table.contains(word)) {
	// pw.println("NE" + "(" + r + " ," + c + "): " + word);
	// totalWords ++;
	// }

	// }
	// // NW (row-1, col - 1)
	// if(boundN ==r-wordlen && boundW==c-wordlen){
	// String word = "";
	// int count = 0;
	// int y = r;
	// int x = c;
	// while(count < wordlen){
	// word += grid[y][x];
	// y--;
	// x--;
	// count ++;
	// }
	// if(table.contains(word)){
	// pw.println("NW" + "("+r+" ,"+c+"): " + word);
	// totalWords ++;
	// }
	// }
	// // SW (row + 1, col -1)
	// if(boundS ==r+wordlen && boundW==c-wordlen){
	// String word = "";
	// int count = 0;
	// int y = r;
	// int x = c;
	// while(count < wordlen){
	// word += grid[y][x];
	// y ++;
	// x--;
	// count ++;
	// }
	// if(table.contains(word)){
	// pw.println("SW" + "("+r+" ,"+c+"): " + word);
	// totalWords ++;
	// }
	// }
	// // SE (row + 1, col + 1)
	// if(boundS ==r+wordlen && boundE==c+wordlen){
	// String word = "";
	// int count = 0;
	// int y = r;
	// int x = c;
	// while(count < wordlen){
	// word += grid[y][x];
	// y ++;
	// x++;
	// count ++;
	// }
	// // for(int y = r; y < boundS; y++){
	// // for(int x=c; x < boundE; x++){
	// // word += grid[y][x];
	// // }
	// // }
	// if(table.contains(word)){
	// pw.println("SE" + "("+r+" ,"+c+"): " + word);
	// totalWords ++;
	// }
	// }

	// }
	// //break;
	// }

	// }
	// long end = System.currentTimeMillis();
	// pw.println(totalWords + " words found");
	// pw.println("Found all words in " + ((end-start)*1.0/1000) + " seconds.");
	// pw.close();

	// }
}
