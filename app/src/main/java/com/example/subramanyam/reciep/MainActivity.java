package com.example.subramanyam.reciep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.kimkevin.cachepot.CachePot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ReciepieData> foodItems;
 ArrayList<String> food;
ArrayList<String> ingre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodItems=new ArrayList<>();
        CachePot.getInstance().push("recd",foodItems);
food=new ArrayList<>();
ingre=new ArrayList<>();
        try {
            jsonData();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
Receipe receipe=new Receipe();
        init(receipe);

    }




    public String loadJSONFromAsset() throws IOException {


        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try {
            String json=null;
            inputStream=getAssets().open("baking.json");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while ((json =bufferedReader.readLine()) != null)
            {
                builder.append(json);
            }

        } finally {
            if(inputStream != null)
            {
                inputStream.close();
            }
        }
        return new String(builder);

    }
    public void jsonData() throws JSONException, IOException {
        foodItems=new ArrayList<>();

        String json=loadJSONFromAsset();
        JSONArray jsonArray=new JSONArray(json);
        for(int i=0;i<jsonArray.length();i++)
        {
            ReciepieData reciepieData=new ReciepieData();

            JSONObject receipe=jsonArray.getJSONObject(i);

            reciepieData.setId(receipe.getInt("id"));
            reciepieData.setName(receipe.getString("name"));
            reciepieData.setIngridients(receipe.getString("ingredients"));

            String jks=reciepieData.getName();

            food.add(jks);
            CachePot.getInstance().push("item",food);


            Log.i("ervf",reciepieData.getName());




            JSONArray jsonArray1=receipe.getJSONArray("ingredients");

            for(int j=0;j<jsonArray1.length();j++)
            {
               IndegrientData reciepieData1=new IndegrientData();
                JSONObject ingredients=jsonArray1.getJSONObject(i);
                reciepieData1.setQuantity(ingredients.getInt("quantity"));
                reciepieData1.setMeasure(ingredients.getString("measure"));
                reciepieData1.setMeasure(ingredients.getString("ingredient"));
                CachePot.getInstance().push("inde",reciepieData1.ingredient);



            }
            JSONArray jsonArray2=receipe.getJSONArray("steps");
            for(int k=0;k<=jsonArray2.length();k++)
            {
                StepsData reciepieData1=new StepsData();
                JSONObject steps=jsonArray2.getJSONObject(i);
                reciepieData1.setId(steps.getInt("id"));
                reciepieData1.setShortDescription(steps.getString("shortDescription"));
                reciepieData1.setDescription(steps.getString("description"));
                reciepieData1.setVideoURL(steps.getString("videoURL"));
                reciepieData1.setThumbnailURL(steps.getString("thumbnailURL"));

                Log.i("xvxv",reciepieData1.getVideoURL());
            }





            String items=reciepieData.getName();
            int id=reciepieData.getId();

            Log.i("kkj",items);
            Log.i("kkr", String.valueOf(id));




        }
    }
    public void init(android.support.v4.app.Fragment fragment)
    {
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameL,fragment);
        fragmentTransaction.commit();
    }




}