package algo.array;

import algo.array.sort.people.TopDownMergeSort;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortPeopleTest {

    private SortPeople service = new TopDownMergeSort();

    @DataProvider(name = "sortPeopleData")
    public Object[][] createSortPeopleData() {
        return new Object[][] {
                {
                        new String[]{"Alice", "Bob", "Charlie"},
                        new int[]{165, 180, 175},
                        new String[]{"Bob", "Charlie", "Alice"}
                },
                {
                        new String[]{"Tom", "Jerry", "Spike"},
                        new int[]{170, 160, 180},
                        new String[]{"Spike", "Tom", "Jerry"}
                },
                {
                        new String[]{"Anna", "Elsa", "Olaf"},
                        new int[]{150, 160, 140},
                        new String[]{"Elsa", "Anna", "Olaf"}
                },
                {
                    new String[]{"ZNEUVTUVYVRMHFbaw","A","ADVLZLLPWNANjx","HZZJokcszj","OITNv","K","KLXRIWORIKARHJmcqva","OKSZBMhxac","TNPCYLB","Ziezabwwgwdrkgnbniv","Qokmgmrqoqymuuhlxplh","PPFLIFBQGEZOFCYNfu","PYKiwdwovpxblggi","Hdmhdkf","IGSDQFWRJHUZCKV","ECMb","U","IBOLPULVXMUALsdcc"},
                    new int[]{61129,88518,96147,42505,12094,61101,70256,64083,79703,22043,28236,36278,15836,28436,82976,77983,41879,21545},
                    new String[]{"ADVLZLLPWNANjx","A","IGSDQFWRJHUZCKV","TNPCYLB","ECMb","KLXRIWORIKARHJmcqva","OKSZBMhxac","ZNEUVTUVYVRMHFbaw","K","HZZJokcszj","U","PPFLIFBQGEZOFCYNfu","Hdmhdkf","Qokmgmrqoqymuuhlxplh","Ziezabwwgwdrkgnbniv","IBOLPULVXMUALsdcc","PYKiwdwovpxblggi","OITNv"}
                },
                {
                    new String[]{"QSXT","A","EWJXZLVLBZPGYQLVDZe","ONFLAPLOWQEFwynun","FUTxqyrelo","IOQZFSTXSDVBQM","ZFgxpgiwqjdclim","QZ","OAWXABTPJZZVO","KJFLSORihirvqcp","Urmpgtibd","GHXIWWZIIJZRMTYHZNR","AOKbuabrusrx","LTYXsi","DTXl","Kerr","Hzezekhpetnds","VZvyfuewqfvzllfc","MIWXGwc","RZUPdrflbfoarikrhvx","APXPCigztuakkkyslhwg","JQTKLRCAZrlmwiqkuye","ZN","GTWLDchwlb","C","VJGRMOQEVYXNodxpcyh","PPHHnlw","LLADHOXKGSCGEdgiemxd","CBLd","JRYXPSWUAUM","Z","OQSWHUPOQFTthzeduc","LZGXKB","AGJCIBOxwetlepgoze","TIZNMHMOCEQATWbuqigi","XJ","FKMUEXz","FSROKDTPRSnq","NDMvlyrhdodnqdybbozp","NAMEWIHGGFsgggcnvq","R","EWLeppmngitbeny","MSFSIoimjln","EGSIOXn","PHOUUlckeexcz","QLVLCUjvod","GITDOSUUWhyrulbhzacd","ZJQQAgaggf","HSHWuxuzlvocovh","TYOQOthrfm","JBESsjrsc","PBYJpwruwfgkkstx","ANQZXGKVNLCSpzkwsic","OBvkcybneet","HLngkytfiaxbgzolox","Gtxrhebdjq","OMNZBRFn","Erfwwhuqw","NLt","LJYE","XSLNOFYCQFHgdffchw","J","XSMBHEWHRIDDQRLRVRk","BSi","XNODX","Xqy","Gslwlywabqc","GMFLHSztig","Muef","Jzipcwswjbzev"}
                ,new int[]{1734,37804,84881,5022,40412,49596,8249,14207,74452,54483,78061,42692,59503,13141,8312,68115,31668,5334,8216,2559,50052,29157,738,30263,35445,33652,22944,40516,25190,9611,86870,34239,68570,28680,45816,41305,5985,29216,98926,34592,96739,85960,21324,85700,41181,66648,9836,22697,34900,26385,4948,31996,97941,33336,43681,97615,74974,39821,31669,52743,92320,35944,17383,30264,21459,66335,62380,53906,25270,40837}
                ,new String[]{"NDMvlyrhdodnqdybbozp","ANQZXGKVNLCSpzkwsic","Gtxrhebdjq","R","XSLNOFYCQFHgdffchw","Z","EWLeppmngitbeny","EGSIOXn","EWJXZLVLBZPGYQLVDZe","Urmpgtibd","OMNZBRFn","OAWXABTPJZZVO","LZGXKB","Kerr","QLVLCUjvod","Xqy","Gslwlywabqc","AOKbuabrusrx","KJFLSORihirvqcp","GMFLHSztig","LJYE","APXPCigztuakkkyslhwg","IOQZFSTXSDVBQM","TIZNMHMOCEQATWbuqigi","HLngkytfiaxbgzolox","GHXIWWZIIJZRMTYHZNR","XJ","PHOUUlckeexcz","Jzipcwswjbzev","LLADHOXKGSCGEdgiemxd","FUTxqyrelo","Erfwwhuqw","A","J","C","HSHWuxuzlvocovh","NAMEWIHGGFsgggcnvq","OQSWHUPOQFTthzeduc","VJGRMOQEVYXNodxpcyh","OBvkcybneet","PBYJpwruwfgkkstx","NLt","Hzezekhpetnds","BSi","GTWLDchwlb","FSROKDTPRSnq","JQTKLRCAZrlmwiqkuye","AGJCIBOxwetlepgoze","TYOQOthrfm","Muef","CBLd","PPHHnlw","ZJQQAgaggf","XNODX","MSFSIoimjln","XSMBHEWHRIDDQRLRVRk","QZ","LTYXsi","GITDOSUUWhyrulbhzacd","JRYXPSWUAUM","DTXl","ZFgxpgiwqjdclim","MIWXGwc","FKMUEXz","VZvyfuewqfvzllfc","ONFLAPLOWQEFwynun","JBESsjrsc","RZUPdrflbfoarikrhvx","QSXT","ZN"}
                }
        };
    }

    @Test(dataProvider = "sortPeopleData")
    public void testSortPeople(String[] names, int[] heights, String[] expectedSortedNames) {
        String[] actualSortedNames = service.sortPeople(names, heights);
        Assert.assertEquals(actualSortedNames, expectedSortedNames);
    }
}
