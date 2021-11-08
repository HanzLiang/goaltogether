# goaltogether
Covid-19 has brought changes to our social manner. Concerts and parties are canceled, people have limited ways to connect with other people. The coronavirus is here forever. We need to know how to live with it. We hope to use technology to help us recommend new friends. Covid-19 has also brought trauma. From August 2020 to February 2021, the number of adults with recent symptoms of an anxiety or depressive disorder increased by more than 40%. Many Covid-19 emotional support helplines are set up to connect with people facing emotional problems. However, due to the lack of volunteers and reluctance to seek help from unknown people, few people can get proper support when facing emotional problems. In the background of living with covid-19, we hope to use technology to help people get connected and find partners. When people get depressed, they can have a choice to go to their partner for help. 

This project mainly focuses on designing a matching algorithm to pair people with similar goals and interests. In order to adapt this algorithm to daily life, the project also includes designing an IOS app GoalTogether. We will apply the proposed algorithm to this app and help people to find partners.

Users could share their own interests and goals on the APP. On the one hand, this APP would help users to manage and remind them of their goals. On the other hand, the matching algorithm will recommend people who they might want to talk with and gather these people in a chat room if granted. It would be easier for users who had common interests and situations to start a conversation, which would help users to make friends easily.



![Image text](./axure/page_1.png)

![Image text](./axure/page_2.png)

![Image text](./axure/page_3.png)

![Image text](./axure/page_4.png)

![Image text](./axure/page_5.png)

### GoalTogether需求文档

#### 1. 用户注册

##### 1.1 注册

接口url：/register

请求方式：POST

请求参数：

| 参数名称 | 参数类型 | 说明 |
| -------- | -------- | ---- |
| account  | string   | 账号 |
| password | string   | 密码 |
| nickname | string   | 昵称 |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": "token"
}
```

#### 2. 用户登录

##### 2.1 登录

接口url：/login

请求方式：POST

| 参数名称 | 参数类型 | 说明 |
| -------- | -------- | ---- |
| account  | string   | 账号 |
| password | string   | 密码 |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": "token"
}
```

##### 2.2 获取用户信息

接口url：/users/currentUser

请求方式：GET

请求参数：

| 参数名称      | 参数类型 | 说明            |      |
| ------------- | -------- | --------------- | ---- |
| Authorization | string   | 头部信息(TOKEN) |      |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": {
        "id":1,
        "account":"1",
        "nickaname":"1",
        "avatar":"ss"
    }
}
```

##### 2.3 退出登录

接口url：/logout

请求方式：GET

请求参数：

| 参数名称      | 参数类型 | 说明            |
| ------------- | -------- | --------------- |
| Authorization | string   | 头部信息(TOKEN) |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": null
}
```

#### 3. 目标

##### 3.1 创建目标

接口url：/goals/create

请求方式：POST

请求参数：

| 参数名称    | 参数类型 | 说明     |
| ----------- | -------- | -------- |
| name        | string   | 目标名称 |
| description | string   | 目标描述 |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": {
        "id":1
    }
}
```

##### 3.2 浏览目标

接口url：/goals/view

请求方式：GET

请求参数：

| 参数名称 | 参数类型 | 说明 |
| -------- | -------- | ---- |
| account  | string   | 账号 |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
    "data": [
        {
            "id": 1,
            "userid": "liang",
            "name": "刷leetcode",
            "description": "每天刷10题",
            "reward": 5,
            "createDate": "2609-06-26 15:58",
            "tags": "学习",
            "status": "ongoing"
        },
        {
            "id": 2,
            "account": "liang",
            "name": "健身",
            "summary": "今天去健身",
            "reward": 1,
            "createDate": "2609-06-26 15:58",
            "tags": "运动",
            "status": "finish"
        },
        {
            "id": 3,
            "account": "liang",
            "name": "学后端",
            "summary": "学习springboot",
            "reward": 1,
            "createDate": "2609-06-26 15:58",
            "tags": "学习",
            "status": "ongoing"
        },        
    ]
}
```

##### 3.3 删除目标

接口url：/goals/delete

请求方式：POST

请求参数：

| 参数名称 | 参数类型 | 说明   |
| -------- | -------- | ------ |
| account  | string   | 账号   |
| id       | string   | 目标id |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success",
}
```

##### 3.4 完成目标

接口url：/goals/complete

请求方式：POST

请求参数：

| 参数名称 | 参数类型 | 说明   |
| -------- | -------- | ------ |
| account  | string   | 账号   |
| id       | string   | 目标id |

返回数据：

```json
{
    "success": true,
    "code": 200,
    "msg": "success"
}
```

#### 4. 共享

##### 4.1 



#### 5.数据库

目标表

```sql
CREATE TABLE `goaltogether`.`ms_goal`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标描述',
  `reward` int(0) NULL DEFAULT NULL COMMENT '奖励',
  `create_date` bigint(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```



用户表

```sql
CREATE TABLE `goaltogether`.`ms_sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `admin` bit(1) NULL DEFAULT NULL COMMENT '是否管理员',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_date` bigint(0) NULL DEFAULT NULL COMMENT '注册时间',
  `deleted` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `last_login` bigint(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `mobile_phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

```



下一步需要完成的：

一个简单的前端部分

用户登录的拦截配置

删除目标（都和id有关）

完成目标（都和id有关）



