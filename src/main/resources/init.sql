/**
 * 权限数据
 *
 */
INSERT INTO t_permission(id,name,description)VALUES(1,'*','nothing');


INSERT INTO t_permission(id,name,description)VALUES(2,'user:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(3,'user:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(4,'user:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(5,'user:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(6,'user:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(7,'user:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(8,'typeCode:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(9,'typeCode:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(10,'typeCode:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(11,'typeCode:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(12,'typeCode:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(13,'typeCode:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(14,'supplierInfo:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(15,'supplierInfo:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(16,'supplierInfo:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(17,'supplierInfo:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(18,'supplierInfo:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(19,'supplierInfo:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(20,'purchaseRecord:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(21,'purchaseRecord:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(22,'purchaseRecord:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(23,'purchaseRecord:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(24,'purchaseRecord:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(25,'purchaseRecord:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(26,'purchaseDetails:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(27,'purchaseDetails:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(28,'purchaseDetails:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(29,'purchaseDetails:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(30,'purchaseDetails:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(31,'purchaseDetails:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(32,'log:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(33,'log:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(34,'log:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(35,'log:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(36,'log:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(37,'log:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(38,'order:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(39,'order:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(40,'order:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(41,'order:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(42,'order:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(43,'order:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(44,'storage:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(45,'storage:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(46,'storage:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(47,'storage:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(48,'storage:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(49,'storage:queryAll','nothing');


INSERT INTO t_permission(id,name,description)VALUES(50,'permission:*','nothing');
INSERT INTO t_permission(id,name,description)VALUES(51,'permission:insert','nothing');
INSERT INTO t_permission(id,name,description)VALUES(52,'permission:query','nothing');
INSERT INTO t_permission(id,name,description)VALUES(53,'permission:update','nothing');
INSERT INTO t_permission(id,name,description)VALUES(54,'permission:delete','nothing');
INSERT INTO t_permission(id,name,description)VALUES(55,'permission:queryAll','nothing');


/**
 * 过期药物权限
 */
INSERT INTO t_permission(id,name,description)VALUES(56,'outTimeDrug:query','nothing');


/**
 * Excel 报表权限
 */
INSERT INTO t_permission(id,name,description)VALUES(57,'excel:query:suppliers','nothing');
INSERT INTO t_permission(id,name,description)VALUES(58,'excel:query:sellRecord','nothing');
INSERT INTO t_permission(id,name,description)VALUES(59,'excel:query:purchaseRecord','nothing');
INSERT INTO t_permission(id,name,description)VALUES(60,'excel:query:typeCode','nothing');
INSERT INTO t_permission(id,name,description)VALUES(61,'excel:query:drugStorage','nothing');
INSERT INTO t_permission(id,name,description)VALUES(62,'excel:query:log','nothing');
INSERT INTO t_permission(id,name,description)VALUES(63,'excel:query:outDrug','nothing');



/**
 * 初始化用户数据
 */

INSERT INTO t_user(id,userName,email,password,status,description)
VALUES(1,'wanderer','wandererchen@foxmail.com','123456789',1,'nothing');
INSERT INTO t_user(id,userName,email,password,status,description)
VALUES(2,'clay','123456@qq.com','123456789',1,'nothing');
INSERT INTO t_user(id,userName,email,password,status,description)
VALUES(3,'whoami','456789@qq.com','123456789',1,'nothing');

/**
 * 用户、权限关联数据
 */

INSERT INTO t_userAndPermission(id,userId,pId)VALUES(1,1,1);
INSERT INTO t_userAndPermission(id,userId,pId)VALUES(2,2,2);
INSERT INTO t_userAndPermission(id,userId,pId)VALUES(3,2,8);


/**
 * 药物代码数据
 */

INSERT INTO t_drugTypeCode(id,typeName,description)VALUES(1,'西药','采用现代化技术合成的药剂');
INSERT INTO t_drugTypeCode(id,typeName,description)VALUES(2,'中药','古代方式药物，通过药草熬制');


