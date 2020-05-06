package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


// ファイル読み書き操作のモジュール
public class TxtIO {
    // 読み込みファイル名
    private static final String inputFile = "sample.txt";

    // ファイル読み込み、置き換え、出力メソッド
    public void ioStream() throws IOException {

        // 読み込み文字列格納用
        StringBuilder sb = new StringBuilder();

        // 読み込みファイルのパス取得
        Path path = Paths.get(inputFile);

        // BufferedReaderでラッパーする(速度向上の為)
        BufferedReader in = Files.newBufferedReader(path);

        // 行データを入れる文字列
        String line;

        // 置き換え後の文字列格納用
        String afterLine;

        // 全ての行を読み込む
        while ((line=in.readLine()) != null) {

            // 文字列置き換え("、"→"!"に)
            afterLine = line.replace("、", "！");

            // 確認用のログを出力
            System.out.println(afterLine);

            // 1行ずつ読み込んだ文字列を追加していく
            sb.append(afterLine);

            // 改行
            sb.append("\n");
        }
        // 出力ファイル読み込み
        PrintWriter out = new PrintWriter("output.txt");

        // 出力処理
        out.print(sb);
        out.close();
    }
}
