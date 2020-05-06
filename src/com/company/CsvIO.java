package com.company;

import java.io.*;
import java.util.*;


public class CsvIO {
    private static final String FILENAME = "test.csv";
    private static final String OUTFILE = "result.csv";

    public static void main(String[] args) throws IOException {

        // 整形後に格納する用
        List<List<String>> list = new ArrayList<>();

        // ファイル読み込み
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILENAME), "UTF8"));

        //csvファイルから読みこんだデータを格納するString
        String line;
        while ((line=br.readLine()) != null) {

            //csvの一行を格納するリスト
            String[] array = line.split(",", 0);

            // D列の値が男性だけを抽出(それ以外はスキップ)
            if(array[2].equals("男性")) {
                continue;
            }

            // 配列をString型のリストにキャスト(要素は配列)
            List<String> arrayList = new ArrayList<>(Arrays.asList(array));

            // A列を削除
            arrayList.remove(0);

            // リストに1行データを格納
            list.add(arrayList);
        }

        // SJISに出力できるようにする(文字化け防止)
        PrintWriter pw = new PrintWriter
                (new BufferedWriter(new OutputStreamWriter
                        (new FileOutputStream(OUTFILE),"SJIS")));


        // カンマ区切りに変換、書き込み処理
        for(List<String> l: list) {
            pw.println(String.join(",", l));
        }
        pw.close();
        System.out.println("出力完了");
    }
}

