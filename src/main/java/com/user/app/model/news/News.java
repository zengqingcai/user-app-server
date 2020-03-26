package com.user.app.model.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Authod:zeng
 * @Date: 2020/3/25 17:09
 * @Version: 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {

    private Integer id;

    private String title;

    private String content;


}
