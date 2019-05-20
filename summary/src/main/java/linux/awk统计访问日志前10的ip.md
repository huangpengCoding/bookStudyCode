#回答

####日志格式如下：
`2013-10-29 10:26:09, INFO, send toEmail=wuas6662@163.com,templateId=23,titleId=11,type=3,sendEmail=noreply+renrenzhichang@mail.xiaozhao.com,ip=10.3.22.134,mailType=4,emailId=526f1bd8c8f2a90213662a67`



####shell命令如下：
```cat mail-2013-10-28.log | awk -F ',' '{print $8}' | sort | uniq -c | sort -k1nr | head -10```