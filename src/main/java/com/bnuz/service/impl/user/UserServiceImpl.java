package com.bnuz.service.impl.user;

import com.bnuz.commons.baseRepository.BaseRepository;
import com.bnuz.commons.baseService.impl.BaseServiceImpl;
import com.bnuz.commons.constant.SystemConstant;
import com.bnuz.commons.result.ErrorCode;
import com.bnuz.commons.result.Result;
import com.bnuz.commons.utils.JwtUtils;
import com.bnuz.entity.UserEntity;
import com.bnuz.entity.dto.UserDto;
import com.bnuz.repository.UserRepository;
import com.bnuz.service.user.UserService;
import com.bnuz.utils.Utils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserServiceImpl extends BaseServiceImpl<UserDto, String> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseRepository<UserDto, String> getRepository() {
        return userRepository;
    }

    @Override
    public Result login(String username, String password) {
        try {
            UserDto user = userRepository.findByUsername(username);
            if (user == null) {
                return Result.fail("用户不存在", ErrorCode.BAD_REQUEST);
            } else {
                if (DigestUtils.md5Hex(password).equals(user.getPassword())) {
                    return Result.success(JwtUtils.createJWT("user", user.getUid(), SystemConstant.JWT_TTL), "登录成功");
                } else {
                    return Result.fail("密码错误", ErrorCode.BAD_REQUEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("后台出现异常", ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param userEntity
     * @param
     * @return
     */
    @Override
    public Result register(UserDto userDto, String ip) {
        try {

            // 如果手机号为空
            if (userDto.getPhone() == null || userDto.getPhone().equals("")) {
                return Result.fail("手机号不能为空", ErrorCode.BAD_REQUEST);
            }

            // 如果密码为空
            if (userDto.getPassword() == null || userDto.getPassword().equals("")) {
                return Result.fail("密码不能为空", ErrorCode.BAD_REQUEST);
            }

            // 如果昵称为空
            if (userDto.getNickName() == null || userDto.getNickName().equals("")) {
                return Result.fail("昵称不能为空", ErrorCode.BAD_REQUEST);
            }

            // 检测手机号是否被注册
            if (userRepository.findByPhone(userDto.getPhone()) != null) {
                return Result.fail("该手机号已被注册", ErrorCode.BAD_REQUEST);
            }

            // 注册时必填手机号phone，密码password，昵称
            userDto.setUid(Utils.getUUID32());
            userDto.setUsername(userDto.getPhone());
            userDto.setPassword(DigestUtils.md5Hex(userDto.getPassword()));
            userDto.setEmailStatus((byte) 0);
            userDto.setIconStatus((byte) 0);
            userDto.setGroupId(null);
            userDto.setHasOutfit((byte) 0);
            userDto.setOutfitStatus((short) 0);
            userDto.setIdentification(null);
            userDto.setIdentifyBackCard(null);
            userDto.setIdentifyFaceCard(null);
            userDto.setCityId(0L);
            userDto.setLastIp(ip);
            userDto.setRegisterTime(Utils.getNowSecondTime());
            userDto.setLastLoginTime(Utils.getNowSecondTime());
            userDto.setMoney(0L);
            userDto.setIconStatus((byte) 0);
            // 设置实名
            userDto.setRealName(null);
            userDto.setCheckStatus((short) 0);
            userDto.setQqId(null);
            userDto.setWechatId(null);
            userDto.setWechatOpenid(null);
            userDto.setQqOpenid(null);
            userDto.setIsFrozen((byte) 0);
            userRepository.save(userDto);
        } catch (Exception e) {
            return Result.fail("后台数据异常", ErrorCode.INTERNAL_SERVER_ERROR);
        }
        return Result.success("注册成功");
    }

    /**
     * 用户更改用户信息
     * @param userEntity
     * @return
     */
    @Override
    public Result updateUserInfoByUser(UserDto userDto) {
        try {
            UserDto correctUser = userRepository.findByUid(userDto.getUid());
            if (correctUser == null) {
                return Result.fail("没有操作权限", ErrorCode.FORBIDDEN);
            }
            // 如果密码为空，则不更改
            if (userDto.getPassword() != null && !userDto.getPassword().equals("")) {
                correctUser.setPassword(DigestUtils.md5Hex(userDto.getPassword()));
            }
            correctUser.setIconStatus(userDto.getIconStatus());
            correctUser.setStatus(userDto.getStatus());
            correctUser.setQqId(userDto.getQqId());
            correctUser.setWechatId(userDto.getWechatId());
            correctUser.setPhone(userDto.getPhone());
            correctUser.setEmail(userDto.getEmail());
            correctUser.setSex(userDto.getSex());
            correctUser.setNickName(userDto.getNickName());
            correctUser.setCityId(userDto.getCityId());
            userRepository.save(correctUser);
            return Result.success(correctUser, "更改用户数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统出现了一些小错误", ErrorCode.BAD_REQUEST);
        }

    }

    @Override
    public Result getUserByID(String uid) {
        try {
            return Result.success(userRepository.findByUid(uid), "获取数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("获取数据失败", ErrorCode.BAD_REQUEST);
        }
    }

}