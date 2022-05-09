package com.g9.handbagstore.controller;

import com.g9.handbagstore.config.MyUserDetail;
import com.g9.handbagstore.entity.User;
import com.g9.handbagstore.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class UserSession {
    public static void getLoggedUserInfo(UserService userService, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;

        if (principal instanceof MyUserDetail){
            String username = ((MyUserDetail) principal).getUsername();
            user = userService.getUserByUserName(username);

            String tmpAvatar = userService.getUserByUserName(username).getAvatar();

            String avatar = (tmpAvatar != null)
                    ? tmpAvatar
                    : "";

            if (!avatar.isEmpty()){
                model.addAttribute("userAvatar", "data:image/png;base64," + avatar);
            }
        }

        model.addAttribute("userLastName", user.getLastName());
    }
}
