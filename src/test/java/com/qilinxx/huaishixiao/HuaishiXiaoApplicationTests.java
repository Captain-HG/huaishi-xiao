package com.qilinxx.huaishixiao;

import com.itextpdf.text.DocumentException;
import com.qilinxx.huaishixiao.entity.Role;
import com.qilinxx.huaishixiao.entity.User;
import com.qilinxx.huaishixiao.mapper.FileMapper;
import com.qilinxx.huaishixiao.mapper.RoleMapper;
import com.qilinxx.huaishixiao.mapper.UserMapper;
import com.qilinxx.huaishixiao.mapper.UserRoleMapper;
import com.qilinxx.huaishixiao.service.RoleService;
import com.qilinxx.huaishixiao.service.UserService;
import com.qilinxx.huaishixiao.utils.topdf.TextParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuaishiXiaoApplicationTests {
  @Autowired
    FileMapper fileMapper;
  @Autowired
    RoleMapper roleMapper;
  @Autowired
    UserService userService;
  @Autowired
    UserMapper userMapper;
  @Autowired
    UserRoleMapper userRoleMapper;
  @Autowired
    RoleService roleService;


   @Test
    public void test01(){
       User user = userMapper.selectByPrimaryKey("1");
       user.setAccount("123");
       int i = userService.updateUser(user);
       System.out.println("测试更新："+i);
   }
   @Test
    public void test02(){
       System.out.println(userRoleMapper.selectByUid("1"));
   }
    @Test
    public void test03(){
        Role role = roleMapper.selectByPrimaryKey(null);
        System.out.println(role);
    }
    @Test
    public void test04(){
        User user=userService.selectByAccount("13123456789");
        System.out.println(user);
        if(user==null){
            return;
        }
       if("".equals(user.getRemark())){
            System.out.println("等于空字符");
        }
        if(user.getRemark()==null){
            System.out.println("等于空指针");
        }
        System.out.println("将其赋值后");
        user.setRemark("");
        if("".equals(user.getRemark())){
            System.out.println("等于空字符");
        }
        if(user.getRemark()==null){
            System.out.println("等于空指针");
        }
    }

    @Test
    public void testText() throws IOException, DocumentException {
        //TextParser.getInstance().text2pdf("e:/sourceFile/txt.txt","e:/targetFile/txt.pdf");
        //TextParser.getInstance().text2pdf("e:/sourceFile/html.html","e:/targetFile/html.pdf");
        //TextParser.getInstance().text2pdf("e:/sourceFile/xml.xml","e:/targetFile/xml.pdf");

        //TextParser.getInstance().text2pdf("e:/sourceFile/xls.xls","e:/targetFile/xls.pdf");
        //TextParser.getInstance().text2pdf("e:/sourceFile/doc.doc","e:/targetFile/doc.pdf");//失败

        //TextParser.getInstance().text2pdf("e:/sourceFile/css.css","e:/targetFile/css.pdf");
        //TextParser.getInstance().text2pdf("e:/sourceFile/js.js","e:/targetFile/js.pdf"); //字体较多效果就比较差

        TextParser.getInstance().text2pdf("e:/sourceFile/java.java","e:/targetFile/java.pdf");
        TextParser.getInstance().text2pdf("e:/sourceFile/cpp.cpp","e:/targetFile/cpp.pdf");
        TextParser.getInstance().text2pdf("e:/sourceFile/c.c","e:/targetFile/c.pdf");

        //ArrayList<String> imageUrllist = new ArrayList<String>();
        //imageUrllist.add("e:/sourceFile/jpg.jpg");
        //imageUrllist.add("e:/sourceFile/png.png");
        ////imageUrllist.add("e:/sourceFile/psd.psd"); //psd格式不支持
        //imageUrllist.add("e:/sourceFile/ico.ico");
        ////imageUrllist.add("e:/sourceFile/gif.gif");//只截取了一帧
        //
        //String pdfUrl = "e:/targetFile/image.pdf";
        //File file = PdfManager.Pdf(imageUrllist, pdfUrl);
        //try {
        //    file.createNewFile();
        //} catch (IOException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}

    }

}