package com.lxgs.cms.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
//    @Resource
//    private LoginService loginService;
//    @Resource
//    private UsersService usersService;
    @Before()
    public void setUp() {
//        Users user = usersService.getUserByUserName("admin");
//
//        request = new MockHttpServletRequest();
//        response = new MockHttpServletResponse();
//        LoginUserDto userDto=new LoginUserDto();
//        if(user==null){
//            userDto.setId("695425f2111040a39e0a57ea8e8e53c7");
//            userDto.setUserName("admin");
//        }else{
//            userDto.setId(user.getId());
//            userDto.setUserName(user.getUserName());
//        }
//        loginService.userLoginSuccess(userDto, request, response);

    }

    public static void main(String[] args){
	   	//SearchAccountRequest request = new SearchAccountRequest();
//    	request.setMerchantId("173675683923966");
//    	request.setPrivateKeyPassword("123456");
//    	request.setShopKey("shanghaichengcejinronggs");
//    	request.setSubmitUrl("http://210.51.61.171:18680/hxb/qz/doBusiness.html");
//    	SearchAccountReponse res = UnionPayUtils.getPreDepositAmount(request);
//    	System.out.println(res);
    	
//    	GetUnionResultRequest rs = new GetUnionResultRequest();
//    	rs.setMerchantId(UnionConstants.UNION_DF_MERCHANTID);
//    	rs.setSubmitUrl(UnionConstants.UNION_DF_URL);
//    	rs.setPrivateKeyPassword(UnionConstants.UNION_DF_PRIVATEPASSWORD);
//    	rs.setShopKey(UnionConstants.UNION_DF_DES_KEY);
//    	rs.setPrivateKeyFilePath(UnionConstants.UNION_DF_PRIVATEKEYPATH);
//    	rs.setMerchantSerial("1425547800024694");
//    	try {
//			GetUnionResultReponse res = UnionPayUtils.getUnionDfResult(rs);
//			System.out.println(res);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	GetUnionResultReponse rp = null;
		try {
//			BatchTransRequest request = new BatchTransRequest();
//	    	request.setMerchantId("173675683923966");
//	    	request.setPrivateKeyPassword("123456");
//	    	request.setShopKey("shanghaichengcejinronggs");
//	    	request.setSubmitUrl("http://210.51.61.171:18680/hxb/qz/doBusiness.html");
//			BatchTransResponse rp = UnionPayUtils.sendBatchTransaction(request);
//			SingleDeductRequest request = new SingleDeductRequest();
			//request.setBankCode(bankCode);
//			UnionPayUtils.singleDK(request);
			//查U族单子代扣情况
//			GetUnionDeductResutlRequest request = new GetUnionDeductResutlRequest();
//			request.setMerchantId(UnionConstants.UNION_U_DEDUCT_MERCHANTID);
//			request.setMerchantOrderId("1432091134878123");
//			request.setMerchantSerial("1432091134878123");
//			request.setPrivateKeyFilePath(UnionConstants.UNION_U_DEDUCT_PRIVATEKEYPATH);
//			request.setPrivateKeyPassword(UnionConstants.UNION_U_DEDUCT_PRIVATEPASSWORD);
//			request.setShopKey(UnionConstants.UNION_U_DEDUCT_DES_KEY);
//			request.setSubmitUrl(UnionConstants.UNION_U_DEDUCT_URL);
//			GetUnionDeductReponse rs = UnionPayUtils.getUnionDeductResult(request);
//			System.out.println(rs);
			
			//读取文件  
			//写文件
//			
//		   
//			String txt =  readFile("e:/yyd_bills.txt");
//    		//System.out.println(txt);
//    		String[] a = txt.split(",");
//    		for (int i = 0; i < a.length; i++) {
//			    String b = a[i];
//			    //调用接口
//			    GetUnionDeductResutlRequest request = new GetUnionDeductResutlRequest();
//				request.setMerchantId(UnionConstants.UNION_DEDUCT_MERCHANTID);
//				request.setMerchantOrderId(b);
//				request.setMerchantSerial(b);
//				request.setPrivateKeyFilePath(UnionConstants.UNION_DEDUCT_PRIVATEKEYPATH);
//				request.setPrivateKeyPassword(UnionConstants.UNION_DEDUCT_PRIVATEPASSWORD);
//				request.setShopKey(UnionConstants.UNION_DEDUCT_DES_KEY);
//				request.setSubmitUrl(UnionConstants.UNION_DEDUCT_URL);
//				GetUnionDeductReponse rs = UnionPayUtils.getUnionDeductResult(request);
//				
//			/*	result.setRespCode(root.elementText("respCode"));
//				result.setRespDesc(root.elementText("respDesc"));*/
//				
//				String  sta = ""; 
//				if(rs==null ){
//					sta =  "null";
//				}else{
//				   
//				    if(rs.getRespCode().equals("0005")){
//						sta = rs.getRespDesc();
//					}else{
//						sta = rs.getTransStatus();
//					}
//				}
//				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("E:/yyd_bill_status.txt"),true));//true表示追加到末尾
//				writer.append(b).append(",").append(sta).append("\r\n");
//				writer.flush();//使用Buffered***时一定要先清缓冲区再关闭流
//				writer.close();
//				
//			}
			
    		
    		
    		
			
	     /*   byte[] bytexml = write.toString().getBytes();  
	        try {  
	            OutputStream os = new FileOutputStream(new File("E:/yyd_bill_status.txt"));  
	            os.write(bytexml);  
	            os.flush();  
	            os.close();  
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } */ 
	   
			
			
			
		/*	GetUnionDeductResutlRequest request = new GetUnionDeductResutlRequest();
			request.setMerchantId(UnionConstants.UNION_DEDUCT_MERCHANTID);
			request.setMerchantOrderId("2015050819142057367");
			request.setMerchantSerial("2015050819142057367");
			request.setPrivateKeyFilePath(UnionConstants.UNION_DEDUCT_PRIVATEKEYPATH);
			request.setPrivateKeyPassword(UnionConstants.UNION_DEDUCT_PRIVATEPASSWORD);
			request.setShopKey(UnionConstants.UNION_DEDUCT_DES_KEY);
			request.setSubmitUrl(UnionConstants.UNION_DEDUCT_URL);
			GetUnionDeductReponse rs = UnionPayUtils.getUnionDeductResult(request);
			System.out.println(rs);
			
			IdindataRequest req = new IdindataRequest();
			req.setBankCardNo("6225220112250535");
			req.setAuId("340823198909036711");
			req.setAuName("钱才");
			IdindataResponse res = IdindataUtils.idindataBankCardValidate(req);
			System.out.println(res);*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	System.out.println(rp);
//    	GetUnionDeductResutlRequest rs = new GetUnionDeductResutlRequest();
//    	rs.setMerchantId(UnionConstants.UNION_DEDUCT_MERCHANTID);
//    	rs.setMerchantOrderId("14275223129483");
//    	rs.setSubmitUrl(UnionConstants.UNION_DEDUCT_URL);
//    	rs.setPrivateKeyPassword(UnionConstants.UNION_DEDUCT_PRIVATEPASSWORD);
//    	rs.setShopKey(UnionConstants.UNION_DEDUCT_DES_KEY);
//    	rs.setPrivateKeyFilePath(UnionConstants.UNION_DEDUCT_PRIVATEKEYPATH);
//    	GetUnionDeductReponse rp = null;
//		try {
//			rp = UnionPayUtils.getUnionDeductResult(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(rp);
    	
    	
//    	int[] a = {1,2,3,3,4,1,2,5,4};
//    	int m = 0;
//    	for(int i = 0;i < a.length;i++){
//    		m = m^a[i];
//    	}
//    	System.out.println(m);
    	
//    	WapPayRequest rq = new WapPayRequest();
//    	rq.setMerchantId(UnionConstants.UNION_WAP_MERCHANTID);
//    	rq.setBackUrl(UnionConstants.UNION_WAP_BACK_URL);
//    	rq.setFrontUrl(UnionConstants.UNION_WAP_FRONT_URL);
//    	rq.setMerchantOrderAmt("10");
//    	rq.setMerchantOrderDesc("正常还款");
//    	rq.setMerchantOrderId("12345698745696");
//    	rq.setMerchantOrderTime("20150322100258");
//    	rq.setPrivateKeyFilePath(UnionConstants.UNION_WAP_PRIVATEKEYPATH);
//    	rq.setPrivateKeyPassword(UnionConstants.UNION_WAP_PRIVATEPASSWORD);
//    	rq.setMerchantName(UnionConstants.UNION_WAP_MERCHANTNAME);
//    	rq.setSubmitUrl(UnionConstants.UNION_WAP_URL);
//    	rq.setShopKey(UnionConstants.UNION_WAP_DES_KEY);
//    	try {
//			WapPayResponse rs = UnionPayUtils.wapPreOrder(rq);
//			System.out.println(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	GetWapPayResultRequest rq = new GetWapPayResultRequest();
//    	rq.setMerchantId(UnionConstants.UNION_WAP_MERCHANTID);
//    	rq.setMerchantOrderId("12345698745696");
//    	rq.setPrivateKeyFilePath(UnionConstants.UNION_WAP_PRIVATEKEYPATH);
//    	rq.setShopKey(UnionConstants.UNION_WAP_DES_KEY);
//    	rq.setTransDate("20150322100258");
//    	rq.setPrivateKeyPassword(UnionConstants.UNION_WAP_PRIVATEPASSWORD);
//    	rq.setSubmitUrl(UnionConstants.UNION_WAP_URL);
//    	rq.setMerchantName(UnionConstants.UNION_WAP_MERCHANTNAME);
//    	try {
//			GetWapPayResultResponse rs = UnionPayUtils.getWapPreOrderResult(rq);
//			System.out.println(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	WapSdkPayRequst rq = new WapSdkPayRequst();
//    	rq.setMerchantId(UnionConstants.UNION_WAP_SDK_MERCHANTID);
//    	rq.setMerchantOrderAmt("100");
//    	rq.setMerchantSerial("1236989787909886667");
//    	rq.setPrivateKeyFilePath(UnionConstants.UNION_WAP_SDK_PRIVATEKEYPATH);
//    	rq.setPrivateKeyPassword(UnionConstants.UNION_WAP_SDK_PRIVATEPASSWORD);
//    	rq.setPublicKeyPath(UnionConstants.UNION_WAP_SDK_PUBLICKEY);
//    	rq.setSubmitUrl(UnionConstants.UNION_WAP_SDK_URL);
//    	OrdersBean o = UnionPayUtils.wapSdkPay(rq);
//    	System.out.println(o);
    	
//    	WapSdkPayRequst rq = new WapSdkPayRequst();
//    	rq.setMerchantId(UnionConstants.UNION_WAP_SDK_MERCHANTID);
//    	rq.setMerchantSerial("1409034909567360");
//    	rq.setPrivateKeyFilePath(UnionConstants.UNION_WAP_SDK_PRIVATEKEYPATH);
//    	rq.setPrivateKeyPassword(UnionConstants.UNION_WAP_SDK_PRIVATEPASSWORD);
//    	rq.setPublicKeyPath(UnionConstants.UNION_WAP_SDK_PUBLICKEY);
//    	rq.setSubmitUrl(UnionConstants.UNION_WAP_SDK_URL);
//    	OrdersBean o = UnionPayUtils.getWapSdkPayResult(rq);
//    	System.out.println(o);
    }
    
    
    /**
	 * 读取文件内容
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	 public static String readFile(String fileName) throws Exception {
	    String fileContent = "";
//		File f = new File(fileName);
//		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader((new InputStreamReader(new FileInputStream(fileName),"GB2312")));
		String line = "";
		while ((line = reader.readLine()) != null)
		{
			 fileContent = fileContent + line;
//			 System.out.println( EncodingUtils.getString(fileContent.getBytes(),"utf-8"));
		}
		reader.close();
		return fileContent;
	}
}
