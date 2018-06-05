import com.bnuz.commons.constant.SystemConstant;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.dto.ActivityCallOverExcelDto;
import com.bnuz.service.impl.MiniProgramServiceImpl;
import com.bnuz.utils.excel.ExcelUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Entry.class)
//@WebAppConfiguration
public class BaseTest {
//    @Autowired
//    private ActivityAttendentService activityAttendentService;

    @Test
    public void testAttendent() {
//        .activityAttendentService.loginByMiniProgram()
    }

    @Test
    public void testToken() {
        try {
            System.out.println(JwtUtils.createJWT("user", "123456", SystemConstant.JWT_TTL));
            String token = JwtUtils.createJWT("user", "123456", SystemConstant.JWT_TTL);
            Claims claims = JwtUtils.parseJWT(token);
            System.out.println(claims.get("sub"));

        } catch (Exception e) {

        }
    }

    @Test
    public void testMiniProgramQRCode() {
        MiniProgramServiceImpl miniProgramService = new MiniProgramServiceImpl();
        String accessToken = miniProgramService.getAcessToken();
        System.out.println(miniProgramService.getMiniProgramActivityQRCode(accessToken, "123456"));
    }


    @Test
    public void testExcel () throws Exception {
        System.out.println(this.getClass().getResource("/"));
        List<ActivityCallOverExcelDto> list = new ArrayList<>();
        list.add(new ActivityCallOverExcelDto("yqq", "123456", "否"));
        list.add(new ActivityCallOverExcelDto("yhy", "fsdfdf", "否"));
        list.add(new ActivityCallOverExcelDto("ytttt", "fsdfdf", "否"));

        Map<String, String> map = new HashMap<>();
        map.put("title", "签到表（切记不要更改表的结构）");
        map.put("total", list.size() + "条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info-template.xls", new FileOutputStream("D:\\my_workspace\\out.xls"),
                list, ActivityCallOverExcelDto.class, true);
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }
}