package com.example.chaitanya.barcodescanner;

import android.app.Activity;
import android.app.ProgressDialog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.id;


public class MainActivity extends ActionBarActivity  {
    private String codeFormat, codeContent;
    private EditText formatTxt, contentTxt, formatTxt1, contentTxt1, contentTxt2, contentTxt3,contentTxt4,contentTxt5,contentTxt6,contentTxt7,contentTxt8,contentTxt9;
    private EditText textViewResult1;
    private EditText textViewResult2;
    private EditText textViewResult3 ;
    private EditText textViewResult4,textViewResult5,textViewResult6,textViewResult7,textViewResult8,textViewResult9,textViewResult10 ;
    private TextView textView2, txtn1,txtn2,txtn3,txtn4,txtn5,txtn6,txtn7,txtn8,txtn9,txtn10;
    private ProgressDialog loading;
    public String temp1;
    int number;
    int i = 1;
    Integer num1 , num2 , num3 , num4 ,num5,num6,num7,num8,num9,num10,bill=0;
    Button btnAdd , buttonp , button2 , button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contentTxt = (EditText) findViewById(R.id.scan_content);
        contentTxt1 = (EditText) findViewById(R.id.scan_content);
        contentTxt2 = (EditText) findViewById(R.id.scan_content);
        contentTxt3 = (EditText) findViewById(R.id.scan_content);
        contentTxt4 = (EditText) findViewById(R.id.scan_content);
        contentTxt5 = (EditText) findViewById(R.id.scan_content);
        contentTxt6 = (EditText) findViewById(R.id.scan_content);
        contentTxt7 = (EditText) findViewById(R.id.scan_content);
        contentTxt8 = (EditText) findViewById(R.id.scan_content);
        contentTxt9 = (EditText) findViewById(R.id.scan_content);

        textView2 = (TextView) findViewById(R.id.textView2);
        textViewResult1 = (EditText) findViewById(R.id.textViewResult1);
        textViewResult2 = (EditText) findViewById(R.id.textViewResult2);
        textViewResult3 = (EditText) findViewById(R.id.textViewResult3);
        textViewResult4 = (EditText) findViewById(R.id.textViewResult4);
        textViewResult5 = (EditText) findViewById(R.id.textViewResult5);
        textViewResult6 = (EditText) findViewById(R.id.textViewResult6);
        textViewResult7 = (EditText) findViewById(R.id.textViewResult7);
        textViewResult8 = (EditText) findViewById(R.id.textViewResult8);
        textViewResult9 = (EditText) findViewById(R.id.textViewResult9);
        textViewResult10 = (EditText) findViewById(R.id.textViewResult10);


        txtn1=(TextView) findViewById(R.id.txtn1);
        txtn2=(TextView) findViewById(R.id.txtn2);
        txtn3=(TextView) findViewById(R.id.txtn3);
        txtn4=(TextView) findViewById(R.id.txtn4);
        txtn5=(TextView) findViewById(R.id.txtn5);
        txtn6=(TextView) findViewById(R.id.txtn6);
        txtn7=(TextView) findViewById(R.id.txtn7);
        txtn8=(TextView) findViewById(R.id.txtn8);
        txtn9=(TextView) findViewById(R.id.txtn9);
        txtn10=(TextView) findViewById(R.id.txtn10);
        btnAdd = (Button)findViewById(R.id.button);
        buttonp = (Button)findViewById(R.id.buttonp);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        btnAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v ) {


                textView2.setText(Integer.toString(a));
buttonp.setVisibility(View.VISIBLE);


            }

        });
        buttonp.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
button3.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                textViewResult1.setText(null);

                a=a-num1;
                num1=0;
                txtn1.setText(null);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;


        }

        return super.onOptionsItemSelected(item);



    }   /**
     * event handler for scan button
     *
     * @param view view of the activity
     */
    public void scanNow(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        integrator.setPrompt(this.getString(R.string.scan_bar_code));
        integrator.setResultDisplayDuration(0);
        integrator.setWide();  // Wide scanning rectangle, may work better for 1D barcodes
        integrator.setCameraId(0);


        // Use a specific camera of the device
        integrator.initiateScan();
        number++;
    }


    /**
     * function handle scan result
     *
     * @param requestCode scanned code
     * @param resultCode  result of scanned code
     * @param intent      intent
     */

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null && number == 1)  {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt.setText(codeContent);

            getData();

        } else if (scanningResult != null && number == 2) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt1.setText(codeContent);

            getData1();

        } else if (scanningResult != null && number == 3) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt2.setText(codeContent);

            getData2();

        } else if (scanningResult != null && number == 4) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData3();

        }else if (scanningResult != null && number == 5) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData4();

        }else if (scanningResult != null && number == 6) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData5();

        }else if (scanningResult != null && number == 7) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData6();

        }else if (scanningResult != null && number == 8) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData7();

        }else if (scanningResult != null && number == 9) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData8();

        }else if (scanningResult != null && number == 10) {
            //we have a result
            codeContent = scanningResult.getContents();
            codeFormat = scanningResult.getFormatName();

            // display it on screen

            contentTxt3.setText(codeContent);

            getData9();

        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void getData() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url = Configone.DATA_URL + contentTxt.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void getData1() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                loading.dismiss();

                showJSON1(response1);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }

    private void getData2() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {
                loading.dismiss();

                showJSON2(response2);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }

    private void getData3() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response3) {
                loading.dismiss();

                showJSON3(response3);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }
 private void getData4() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response4) {
                loading.dismiss();

                showJSON4(response4);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }private void getData5() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response5) {
                loading.dismiss();

                showJSON5(response5);
            }
        },
                 new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }private void getData6() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response6) {
                loading.dismiss();

                showJSON6(response6);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }private void getData7() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response7) {
                loading.dismiss();

                showJSON7(response7);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }private void getData8() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response8) {
                loading.dismiss();

                showJSON8(response8);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }private void getData9() {
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);
        String url1 = Configone.DATA_URL + contentTxt1.getText().toString().trim();

        StringRequest stringRequest1 = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response9) {
                loading.dismiss();

                showJSON9(response9);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);
    }
    int a;

    private void showJSON(String response) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult1.setText(price);
        num1 = Integer.parseInt(textViewResult1.getText().toString());
        bill=num1;
    a=bill;
        txtn1.setText(itemname);

    }


    private void showJSON1(String response1) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response1);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult2.setText(price);
        num2 = Integer.parseInt(textViewResult2.getText().toString());
        bill=bill+num2;
        a=a+num2;
        txtn2.setText(itemname);

    }
    private void showJSON2(String response2) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response2);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult3.setText(price);
        num3 = Integer.parseInt(textViewResult3.getText().toString());
        bill=bill+num3;
a=a+num3;
        txtn3.setText(itemname);
    }

   private void showJSON3(String response3) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response3);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult4.setText(price);
        num4 = Integer.parseInt(textViewResult4.getText().toString());
        bill=bill+num4;
        a=a+num4;
        txtn4.setText(itemname);
    }private void showJSON4(String response4) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response4);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult5.setText(price);
        num5 = Integer.parseInt(textViewResult5.getText().toString());
        bill=bill+num5;
        a=a+num5;
        txtn5.setText(itemname);
    }private void showJSON5(String response5) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response5);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult6.setText(price);
        num6 = Integer.parseInt(textViewResult6.getText().toString());
        bill=bill+num6;
        a=a+num6;
        txtn6.setText(itemname);
    }
    private void showJSON6(String response6) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response6);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult7.setText(price);
        num7 = Integer.parseInt(textViewResult7.getText().toString());
        bill=bill+num7;
        a=a+num7;
        txtn7.setText(itemname);
    }private void showJSON7(String response7) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response7);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult8.setText(price);
        num8 = Integer.parseInt(textViewResult8.getText().toString());
        bill=bill+num8;
        a=a+num8;
        txtn8.setText(itemname);
    }private void showJSON8(String response8) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response8);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult9.setText(price);
        num9 = Integer.parseInt(textViewResult9.getText().toString());
        bill=bill+num9;
        a=a+num9;
        txtn9.setText(itemname);
    }private void showJSON9(String response9) {
        String itemname = "";
        String price = "";


        try {
            JSONObject jsonObject = new JSONObject(response9);
            JSONArray result = jsonObject.getJSONArray(Configone.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            itemname = collegeData.getString(Configone.KEY_ITEMNAME);
            price = collegeData.getString(Configone.KEY_PRICE);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textViewResult10.setText(price);
        num10 = Integer.parseInt(textViewResult10.getText().toString());
        bill=bill+num10;
        a=a+num10;
        txtn10.setText(itemname);
    }





}    /* else

        {

            Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }

        }}
        */
