package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        // ファイル入出力クラスのインスタンス生成
        TxtIO ioString = new TxtIO();

        // ファイルの読み込み、置き換え、出力
        ioString.ioStream();
    }
}
