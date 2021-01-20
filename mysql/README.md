## mysql备份
mysqldump -uzhny2.0 -p'ytSg$!vt' zhny_mzm_test  > /data/mysqlbak/zhny_mzm_test/`date +%Y%m%d`.sql;
find /data/mysqlbak -mtime +15 -name "*.sql" -exec rm -rf {} \;
