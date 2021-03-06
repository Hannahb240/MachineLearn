package com.example.hannah.machinelearn;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.ml.KNearest;
import org.opencv.ml.Ml;
import org.opencv.utils.Converters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannah on 22/02/2018.
 */

//To get a high accuracy to begin with (88%):
//In method trainModel(), standing training data =  for (int x = 1; x <= 75; x++) and
//crouching traning data =  for (int x = 10; x <= 82; x++)
//and in method testAccuracyOfModel(), standing testing data = for (int x = 76; x <= 82; x++) and
//crouching testing data = for (int x = 1; x <= 9; x++)

//To get a lower accuracy to begin with (46%), so the model can be, trained:
//In mehthod trainModel(), standing training data = 5-10 and
//crouching trainng data = 10-15
//in method testAccuracyOfModel(), standing testing data  = 15-20
//and crouching testing data = 14-20

public class knn {

    public static int tester = 0;

    public static int numberGuessedCorrectly = 0;
    public static int numberGuessedIncorrectly = 0;

    //Training data variables
    private static Bitmap trainingBitmap;
    private static Mat trainingBitmapToMat;

    //Training data matrix and list of corresponding labels
    public static Mat trainingData;
    public static List<Integer> trainingLabels;

    //Testing data variables
    private static Bitmap testingBitmap;
    private static Mat testingBitmapToMat;

    //Testing data matrix and list of corresponding labels
    public static Mat testingData;
    public static List<Integer> testLabels;

    public static Mat testingDataStanding;
    public static List<Integer> testLabelsStanding;

    public static Mat testingDataCrouching;
    public static List<Integer> testingLabelsCrouching;

    public static KNearest knearestneighbor;
    public static Mat knnresult;

    //Labels
    private static final int standingLabel = 1;
    private static final int crouchingLabel = 2;
    private static final int lyingLabel = 3;

    public static String resultOfKnn;

    public static float accuracyOfReaching;
    public static float accuracyOfCrouching;

    private static Context myContext;

    public knn (Context context)
    {
        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();
        myContext =context;
    }

    public static String doKnn(Bitmap photo, Mat trainData, List<Integer> trainLabels){

//        trainingBitmapToMat = new Mat();
//        trainingData = new Mat();
//        trainingLabels = new ArrayList<Integer>();
//        knearestneighbor = KNearest.create();
//
//        trainModel();
//        testModel(photo);

        return resultOfKnn;

    }
    private static int id;
    public static void trainModel(){

        //Standing training data
        for (int x = 5; x <=5; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("standing" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);

            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            trainingBitmapToMat.reshape(1,1);
            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(standingLabel);
        }

        //Crouching training data
        for (int x = 10; x <= 10; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("crouching" + x, "drawable", myContext.getPackageName());
            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(crouchingLabel);
        }

        //Lying training data
//        for (int x = 1; x <= 14; x++) {
//
//            //Find the training image id
//            id = myContext.getResources().getIdentifier("lying" + x, "drawable", myContext.getPackageName());
//            //Change from drawable to bitmap, to Mat, to float Mat
//            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
//            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//            //Add training data
//            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
//
//            //Add label
//            trainingLabels.add(lyingLabel);
//        }

        knearestneighbor.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));
    }




    public static float testAccuracyOfModel(Mat trainData, List<Integer> trainLabels) {

        //get some train data 30 pics of each pose
        //Standing training dat

//        trainingBitmapToMat = new Mat();
//        trainingData = new Mat();
//        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();

//        for (int x = 1; x <= 30; x++) {
//
//            //Find the training image id
//            id = myContext.getResources().getIdentifier("standing" + x, "drawable", myContext.getPackageName());
//
//            //Change from drawable to bitmap, to Mat, to float Mat
//            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
//            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//            //Add training data
//            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
//
//            //Add label
//            trainingLabels.add(standingLabel);
//        }
        //get some test data 6 pics of each pose
        //Crouching training data
//        for (int x = 1; x <= 36; x++) {
//
//            //Find the training image id
//            id = myContext.getResources().getIdentifier("crouching" + x, "drawable", myContext.getPackageName());
//            //Change from drawable to bitmap, to Mat, to float Mat
//            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
//            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//            //Add training data
//            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
//
//            //Add label
//            trainingLabels.add(crouchingLabel);
//        }

        knearestneighbor.train(trainData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainLabels));

        //testing
        //Get an array of testing data- pics 30 to 36, and add their labels.
        testingData = new Mat();
        testingBitmapToMat = new Mat();
        testLabels = new ArrayList<Integer>();
        knnresult = new Mat();
        ArrayList<Integer> testSuccessVector = new ArrayList<Integer>();

        testingDataStanding = new Mat();
        testingDataCrouching = new Mat();

        testLabelsStanding = new ArrayList<Integer>();
        testingLabelsCrouching = new ArrayList<Integer>();

        ArrayList<Integer> testSuccessVectorStanding = new ArrayList<>();
        ArrayList<Integer> testSuccessVectorCrouching = new ArrayList<>();

        //Standing testing data
        for (int x = 15; x <= 20; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("standing" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            testingData.push_back(trainingBitmapToMat.reshape(1, 1));
            testingDataStanding.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            testLabels.add(standingLabel);
            testLabelsStanding.add(standingLabel);
        }


        //Crouching testing data
        for (int x = 14; x <= 20; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("crouching" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            testingData.push_back(trainingBitmapToMat.reshape(1, 1));
            testingDataCrouching.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            testLabels.add(crouchingLabel);
            testingLabelsCrouching.add(crouchingLabel);
        }

        //test accuracy of standing
        for(int x = 0; x < testingDataStanding.rows(); x++){
            Mat one_feature = testingDataStanding.row(x);
            int testLabel = testLabelsStanding.get(x);
            int p = Math.round(knearestneighbor.findNearest(one_feature, 2, knnresult));
            if(p == testLabel){
                testSuccessVectorStanding.add(1);
            }
            else{
                testSuccessVectorStanding.add(0);
            }
        }

        float totalCorrect = 0;
        for(int y = 0; y < testSuccessVectorStanding.size(); y++ ){
            totalCorrect+= testSuccessVectorStanding.get(y);
        }

        accuracyOfReaching = (totalCorrect / testSuccessVectorStanding.size());

        for(int x = 0; x < testingDataCrouching.rows(); x++){
            Mat one_feature = testingDataCrouching.row(x);
            int testLabel = testingLabelsCrouching.get(x);
            int p = Math.round(knearestneighbor.findNearest(one_feature, 2, knnresult));
            if(p == testLabel){
                testSuccessVectorCrouching.add(1);
            }
            else{
                testSuccessVectorCrouching.add(0);
            }
        }

        float totalCorrect2 = 0;
        for(int y = 0; y < testSuccessVectorCrouching.size(); y++ ){
            totalCorrect2+= testSuccessVectorCrouching.get(y);
        }

        accuracyOfCrouching = (totalCorrect2 / testSuccessVectorCrouching.size());

        //loop through and test accuracy
        for(int x = 0; x < testingData.rows(); x++){
            Mat one_feature = testingData.row(x);
            int testLabel = testLabels.get(x);
            int p = Math.round(knearestneighbor.findNearest(one_feature, 2, knnresult));
            if(p == testLabel){
                testSuccessVector.add(1);
            }
            else{
                testSuccessVector.add(0);
            }
        }

        //Return out accuracy
        float totalCorrect3 = 0;
        for(int y = 0; y < testSuccessVector.size(); y++ ){
            totalCorrect3+= testSuccessVector.get(y);
        }

        return (totalCorrect3 / testSuccessVector.size());
    }

    public static void trainKnnWithExtraData(Bitmap trainPhoto, int label, Mat trainData, List<Integer> trainLabels){

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();
        Bitmap resizedPhoto;
        Bitmap sizeComparison = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.standing1);

        resizedPhoto = Bitmap.createScaledBitmap(trainPhoto, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

        trainData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainLabels.add(label);

        trainingData = trainData;
        trainingLabels = trainLabels;

//        knearestneighbor.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));
    }

    public static float testAccuracyOfModelTwo() {

        //testing
        //Get an array of testing data- pics 30 to 36, and add their labels.
        testingData = new Mat();
        testingBitmapToMat = new Mat();
        testLabels = new ArrayList<Integer>();
        knnresult = new Mat();
        ArrayList<Integer> testSuccessVector = new ArrayList<Integer>();

        //Standing testing data
        for (int x = 61; x <= 75; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("standing" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            testingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            testLabels.add(standingLabel);
        }

        //Crouching testing data
        for (int x = 61; x <= 75; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("crouching" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            testingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            testLabels.add(crouchingLabel);
        }

        //loop through and test accuracy
        for(int x = 0; x < testingData.rows(); x++){
            Mat one_feature = testingData.row(x);
            int testLabel = testLabels.get(x);
            int p = Math.round(knearestneighbor.findNearest(one_feature, 2, knnresult));
            if(p == testLabel){
                testSuccessVector.add(1);
            }
            else{
                testSuccessVector.add(0);
            }
        }

        //Return out accuracy
        float totalCorrect = 0;
        for(int y = 0; y < testSuccessVector.size(); y++ ){
            totalCorrect+= testSuccessVector.get(y);
        }

        return (totalCorrect / testSuccessVector.size());

    }

    public static String trainAndDoKNNWithExtraData(int label, Bitmap testPhoto, Bitmap one, Bitmap two, Bitmap three, Bitmap four, Bitmap five){

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();
        Bitmap resizedPhoto;
        Bitmap sizeComparison = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.standing1);

        trainModel();

        //image one
        resizedPhoto = Bitmap.createScaledBitmap(one, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image two
        resizedPhoto = Bitmap.createScaledBitmap(two, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image three
        resizedPhoto = Bitmap.createScaledBitmap(three, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image four
        resizedPhoto = Bitmap.createScaledBitmap(four, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image five
        resizedPhoto = Bitmap.createScaledBitmap(five, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

//        testModel(testPhoto);
//        float result = testAccuracyOfModel();
        return resultOfKnn;
    }

    public static String testModel(Bitmap photo, Mat trainData, List<Integer> trainLabels){

        knearestneighbor = KNearest.create();
        knearestneighbor.train(trainData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainLabels));

        testingData = new Mat();
        testingBitmapToMat = new Mat();
        testLabels = new ArrayList<Integer>();
        knnresult = new Mat();

        //Resize the photo
        Bitmap sizeComparison = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.standing1);
        Bitmap resizedphoto = Bitmap.createScaledBitmap(photo, sizeComparison.getWidth(), sizeComparison.getHeight(), true);

        //Find test image and convert to bitmap float
        Utils.bitmapToMat(resizedphoto, testingBitmapToMat);
        testingBitmapToMat.convertTo(testingBitmapToMat, CvType.CV_32F);

        //Add test data to matrix
        testingData.push_back(testingBitmapToMat.reshape(1, 1));

        //Add label
        testLabels.add(standingLabel);

        //Getting a feature to test
        Mat one_feature = testingData.row(0);
        int testLabel = testLabels.get(0);
        float p = knearestneighbor.findNearest(one_feature, 2, knnresult);
        resultOfKnn = knnresult.dump();
        return resultOfKnn;



    }

    public Mat getTrainingData(){
        return trainingData;
    }

    public List<Integer> getTrainingLabels(){
        return trainingLabels;
    }

}
