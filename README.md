# TelecomBillingSystem
张先森的课设, 电信计费系统

数据库设计:
>
    用户表 :id , telNumber, name, sex, age, addr, 
    通话记录表 : id, telnumber, time, duration, type
    费率表 : id, duration, price
    管理员表: id, name, password



数据:一下内容请复制粘贴到一个txt文件中

{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 4.2,"type": true}
{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 4.7,"type": true}
{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 3.5,"type": true}
{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 2.2,"type": false}
{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 4.5,"type": false}
{"id": 0,"tel": "18362972517", "name": "zhang", "date":"2016-01-06 14:34:16", "duration": 7.6,"type": false}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 5.2,"type": true}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 7.3,"type": true}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 3.4,"type": false}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 9.3,"type": false}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 1.5,"type": false}
{"id": 0,"tel": "18362972518", "name": "xiaoming", "date":"2016-01-06 14:34:16", "duration": 5.0,"type": false}
{"id": 0,"tel": "18362972519", "name": "李四", date":"2016-01-06 14:34:16", "duration": 5.3,"type": true}
{"id": 0,"tel": "18362972519", "name": "李四", "date":"2016-01-06 14:34:16", "duration": 7.7,"type": true}
{"id": 0,"tel": "18362972519", "name": "李四", "date":"2016-01-06 14:34:16", "duration": 9.0,"type": true}
{"id": 0,"tel": "18362972519", "name": "李四", "date":"2016-01-06 14:34:16", "duration": 7.4,"type": true}
{"id": 0,"tel": "18362972519", "name": "李四", "date":"2016-01-06 14:34:16", "duration": 8.5,"type": false}
{"id": 0,"tel": "18362972519", "name": "李四", "date":"2016-01-06 14:34:16", "duration": 5.6,"type": false}