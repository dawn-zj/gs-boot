package cn.com.gs.library.controller.zxing;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.gs.library.service.impl.zxing.BarcodeServiceImpl;

@Controller
@RequestMapping("/barcode")
public class BarcodeController {
	@Autowired
	private BarcodeServiceImpl barcodeService;
	
	@RequestMapping("/barcodeManage")
	public String toBarcode(){
		return "zxing/barcode";
	}
	
	@RequestMapping("/genImage")
	public void genImage(String content,HttpServletResponse response) {
		System.out.println(content);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("image/gif");
		try {
			byte[] imageData = barcodeService.genImage(content);
			
			ByteArrayInputStream in = new ByteArrayInputStream(imageData);
			BufferedImage image = ImageIO.read(in);
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
