package algo.april;

import algo.annotations.Date;
import algo.april.impl.wp.Lookup;
import algo.april.impl.wp.OptimisedLookup;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordPatternTest {

    private  WordPattern service;

    public WordPatternTest(WordPattern service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory(){
        return  new Object[]{
                new WordPatternTest(new Lookup()),
                new WordPatternTest(new OptimisedLookup())

        };
    }

    @DataProvider
    private Object[][] data(){
        return new Object[][]{
                {"","",true,"empty"},
                {"a","a",true,"identical"},
                {"a","bgh",true,"single letter"},
                {"a","abcd efgh",false,"different length"},
                {"ab","cat dog",true,"match"},
                {"aba","cat dog cat",true,"3 letter match"},
                {"aab","car bike car",false,"different order"},
                {"aab","car car bike",true,"different length words"}
        };
    }

    @Test(dataProvider = "data")
    public void test(String pattern,String s,boolean result,String message){
        assertEquals(service.wordPattern(pattern,s),result,message);
    }
}