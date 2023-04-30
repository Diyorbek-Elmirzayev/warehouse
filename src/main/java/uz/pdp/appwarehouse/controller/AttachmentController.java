package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.payload.ResultMessage;
import uz.pdp.appwarehouse.service.AttachmentService;

import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public ResultMessage upload(MultipartHttpServletRequest request) throws IOException {
      return  attachmentService.uploadFile(request);
    }
}
