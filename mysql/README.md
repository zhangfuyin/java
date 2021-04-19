#索引

 * 概述
 
    索引是帮助mysql高效的查询数据的数据结构。在数据之外、数据库系统还维护着满足特定查找算法的数据结构、这些数据结构以
    某种方式指向数据
    
    
    
 
 * 二叉树
    
    
    
 
 * BTree
 
 * B+Tree


  
   





## mysql备份

mysqldump -uzhny2.0 -p'ytSg$!vt' zhny_mzm_test  > /data/mysqlbak/zhny_mzm_test/`date +%Y%m%d`.sql;
find /data/mysqlbak -mtime +15 -name "*.sql" -exec rm -rf {} \;
