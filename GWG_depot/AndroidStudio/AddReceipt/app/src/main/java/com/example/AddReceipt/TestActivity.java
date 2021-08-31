package com.example.AddReceipt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TestActivity extends AppCompatActivity {
    private Button btn_checkAnswer, btn_finsh, btn_next;
    private TextView tv_trans_amount, tv_answer;
    private String TAG = "testLog";
    int b = 0 ;
    int a = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findview();
        getRandomNum grn = new getRandomNum();
        distributeRandom dr_a = new distributeRandom();
        long[] a_random = dr_a.randoms(grn);
        distributeRandom dr_b = new distributeRandom();
        long[] b_random = dr_b.randoms(grn);
        distributeRandom dr_c = new distributeRandom();
        long[] c_random = dr_c.randoms(grn);
        distributeRandom dr_d = new distributeRandom();
        long[] d_random = dr_d.randoms(grn);
        distributeRandom dr_e = new distributeRandom();
        long[] e_random = dr_e.randoms(grn);

//        以上是Android Studio有关的东东 不用怎么管      重点在下面

//下一个按钮的监听
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b<20){
                    String sjs1 = String.valueOf(a_random[a]);
                    BigDecimal b_dec = new BigDecimal(sjs1);
                    BigDecimal sjs = b_dec.movePointLeft(2);
                    tv_trans_amount.setText(sjs.toString());
                    Log.d(TAG, "onClick: 0-20---"+a_random[a]);
                    Log.d(TAG, "onClick: 0-20--a-"+a);
                    Log.d(TAG, "onClick: 0-20--b-"+b);
                    a++;
                }
                if (b == 20){
                    tv_trans_amount.setText("第二组");
                    Log.d(TAG, "onClick: 第二组   "+a+b);
                    a = 0;
                }

                if (b>20&b<41){
                    String sjs1 = String.valueOf(b_random[a]);
                    BigDecimal b_dec = new BigDecimal(sjs1);
                    BigDecimal sjs = b_dec.movePointLeft(2);
                    tv_trans_amount.setText(sjs.toString());
                    Log.d(TAG, "onClick: 20-40---"+b_random[a]);
                    Log.d(TAG, "onClick: 20-40--a-"+a);
                    Log.d(TAG, "onClick: 20-40--b-"+b);
                    a++;
                }
                if (b == 41){
                    tv_trans_amount.setText("第三组");
                    a = 0;
                }
                if (b>41&b<62){
                    String sjs1 = String.valueOf(c_random[a]);
                    BigDecimal b_dec = new BigDecimal(sjs1);
                    BigDecimal sjs = b_dec.movePointLeft(2);
                    tv_trans_amount.setText(sjs.toString());
                    Log.d(TAG, "onClick: 40-60---"+c_random[a]);
                    Log.d(TAG, "onClick: 40-60--a-"+a);
                    Log.d(TAG, "onClick: 40-60--b-"+b);
                    a++;
                }
                if (b == 62){
                    tv_trans_amount.setText("第四组");
                    a = 0;
                }
                if (b>62&b<83){
                    String sjs1 = String.valueOf(d_random[a]);
                    BigDecimal b_dec = new BigDecimal(sjs1);
                    BigDecimal sjs = b_dec.movePointLeft(2);
                    tv_trans_amount.setText(sjs.toString());
                    Log.d(TAG, "onClick: 60-80---"+d_random[a]);
                    Log.d(TAG, "onClick: 60-80--a-"+a);
                    Log.d(TAG, "onClick: 60-80--b-"+b);
                    a++;
                }
                if (b == 83){
                    tv_trans_amount.setText("第五组");
                    a = 0;
                }
                if (b>83&b<104){
                    String sjs1 = String.valueOf(e_random[a]);
                    BigDecimal b_dec = new BigDecimal(sjs1);
                    BigDecimal sjs = b_dec.movePointLeft(2);
                    tv_trans_amount.setText(sjs.toString());
                    Log.d(TAG, "onClick: 80-100---"+e_random[a]);
                    Log.d(TAG, "onClick: 80-100--a-"+a);
                    Log.d(TAG, "onClick: 80-100--b-"+b);

                    a++;
                }
                b++;
                if (b == 104){
                    tv_trans_amount.setText("结束！！！");
                }

            }
        });
//        检查答案的监听，这个先不管
        btn_checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              遍历五组的随机数列表再求和得出每组随机数列表的总和
                long total = 0;
                for (int i = 0; i < a_random.length; i++) {
                    total += a_random[i];
                }
                String answer_a = String.valueOf(total);

                total = 0;
                for (int i = 0; i < b_random.length; i++) {
                    total += b_random[i];
                }
                String answer_b = String.valueOf(total);

                total = 0;
                for (int i = 0; i < c_random.length; i++) {
                    total += c_random[i];
                }
                String answer_c = String.valueOf(total);

                total = 0;
                for (int i = 0; i < d_random.length; i++) {
                    total += d_random[i];
                }
                String answer_d = String.valueOf(total);

                total = 0;
                for (int i = 0; i < e_random.length; i++) {
                    total += e_random[i];
                }
                String answer_e = String.valueOf(total);
//              小数点左移两位
                BigDecimal b_dec_a = new BigDecimal(answer_a);
                BigDecimal answer_a_l = b_dec_a.movePointLeft(2);

                BigDecimal b_dec_b = new BigDecimal(answer_b);
                BigDecimal answer_b_l = b_dec_b.movePointLeft(2);

                BigDecimal b_dec_c = new BigDecimal(answer_c);
                BigDecimal answer_c_l = b_dec_c.movePointLeft(2);

                BigDecimal b_dec_d = new BigDecimal(answer_d);
                BigDecimal answer_d_l = b_dec_d.movePointLeft(2);

                BigDecimal b_dec_e = new BigDecimal(answer_e);
                BigDecimal answer_e_l = b_dec_e.movePointLeft(2);

                tv_answer.setText(
                        "第一组：     " + answer_a_l.toString() + "\n" +
                        "第二组：     " + answer_b_l.toString() + "\n" +
                        "第三组：     " + answer_c_l.toString() + "\n" +
                        "第四组：     " + answer_d_l.toString() + "\n" +
                        "第五组：     " + answer_e_l.toString() + "\n"
                );

            }
        });
//        结束按钮的监听
        btn_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //    布局id的绑定，不用太管
    private void findview() {

        btn_checkAnswer = findViewById(R.id.btn_check_answer);
        btn_finsh = findViewById(R.id.btn_finsh);
        btn_next = findViewById(R.id.btn_next);

        tv_trans_amount = findViewById(R.id.tv_trans_amount);
        tv_answer = findViewById(R.id.tv_answer);
    }
    //分配随机数
    public class distributeRandom {

    int size = 20;
//       定义数组存20个随机数
        long[] random = new long[size];
        public long[] randoms(getRandomNum grn) {
//            3个5位数
            for (int a=0;a<3;a++){
                random[a] = grn.getRandomNum5();
            }
//            6个6位数
            for (int a=3;a<9;a++){
                random[a] = grn.getRandomNum6();
            }
//            4个7位数
            for (int a=9;a<13;a++){
                random[a] = grn.getRandomNum7();
            }
//            4个8位数
            for (int a=13;a<17;a++){
                random[a] = grn.getRandomNum8();
            }
//            3个九位数
            for (int a=17;a<20;a++){
                random[a] = grn.getRandomNum9();
            }

//          返回一个数组
            return random;
        }
        public void clearnRandom(){
            random = null;
        }
    }
//生成随机数，
    public class getRandomNum {
//        5位数
        public int getRandomNum5() {
            int random5 = new Random().nextInt(99999);
            if (random5 < 10000) {
                random5 += 10000;
            }
            return random5;
        }
//        6位数
        public int getRandomNum6() {
            int random6 = new Random().nextInt(999999);
            if (random6 < 100000) {
                random6 += 100000;
            }
            return random6;
        }
//        7位数
        public int getRandomNum7() {
            int random7 = new Random().nextInt(9999999);
            if (random7 < 1000000) {
                random7 += 1000000;
            }
            return random7;

        }
//        8位数
        public int getRandomNum8() {
            int random8 = new Random().nextInt(99999999);
            if (random8 < 10000000) {
                random8 += 10000000;
            }
            return random8;
//          9位数
        }
        public int getRandomNum9() {
            int random9 = new Random().nextInt(999999999);
            if (random9 < 100000000) {
                random9 += 100000000;
            }
            return random9;

        }
    }

}
