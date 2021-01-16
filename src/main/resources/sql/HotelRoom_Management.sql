--�жϵ�ǰ���ݿ��Ƿ����
If exists (Select * From sysdatabases Where name='HotelRoom_Management')
Drop Database Room_Management  --ɾ�����ݿ�
GO

--�������ݿ�
CREATE DATABASE HotelRoom_Management
ON Primary
(
   NAME =HotelRoom_Management_data,                    
   FILENAME ='D:\DB\HotelRoom_Management.mdf',       
   SIZE =10,                              
   FILEGROWTH=20%                        
)     
LOG ON
(
   NAME =HotelRoom_Management_log,                   
   FILENAME='D:\DB\HotelRoom_Management.ldf', 
   SIZE=10,				 				 
   FILEGROWTH=20%			 
) 
GO

USE HotelRoom_Management
GO

--�ͷ���
CREATE Table tb_room							
(
	room_id INT IDENTITY(10000,1) primary key,			--�����
	room_price varchar(30) not null,					--����۸�
	room_bednum varchar(30) not null,				--��λ����
	room_stat varchar(30) not null,						--����״̬����/�ޣ�
)

--�ͻ���Ϣ��
CREATE Table tb_user_information									
(
	user_account varchar(30) not null primary key,		--�û��˺�
	user_pwd varchar(30) not null,						--�û�����
	user_sfz varchar(30) not NULL,						--�ͻ����֤
	user_name varchar(30)NOT NULL,						--�ͻ�����
	user_sex varchar(4),								--�ͻ��Ա�
	user_age varchar(4),								--�ͻ�����
	user_tel varchar(30)NOT NULL,						--�ͻ���ϵ��ʽ
) 


--����Ա��
create table tb_adminer
(
	admin_account INT IDENTITY(202000,1) primary KEY,		--����Ա�˺�
	admin_name varchar(30) ,							--����Ա����
	admin_pwd varchar(30) default('123456') not null,	--����Ա����
	admin_gender CHAR(10) NOT NULL,					--����Ա�Ա�
	admin_join DATE,							--��ְʱ��
	admin_type VARCHAR(30),								--����Ա����

)

--����Ԥ����
CREATE Table tb_room_reserve								
(
	reserve_id INT IDENTITY(000000,1) primary key,		--Ԥ������
	user_account varchar(30) not null,					--�û��˺�
	room_id INT not null,						--�����
	reserve_time varchar(30) ,					--Ԥ��ʱ��
)

--������ס��
CREATE Table tb_room_check								
(
	check_id INT IDENTITY(010000,1) primary key,		--�������
	user_account varchar(30) not null,					--�û��˺�
	room_id INT not null,						--�����
	check_time varchar(30),					--��סʱ��
	check_out_time varchar(30),				--�˷�ʱ��
)
GO


--tb_room������  ���·���״̬
CREATE TRIGGER reserve ON dbo.tb_room_reserve FOR INSERT
AS
BEGIN
	DECLARE @room_id VARCHAR(30);
	SELECT @room_id = room_id FROM Inserted;
	UPDATE dbo.tb_room
	SET room_stat='��'
	WHERE room_id = @room_id
END
GO

--tb_room_reserve������  ����ǰʱ���Զ�д�����
create trigger res_time on tb_room_reserve for insert
as
begin
	declare @room_id varchar(30),@res_date varchar(50)
	select @res_date=GETDATE();
	select @room_id=room_id from inserted;
	update tb_room_reserve
	set reserve_time=@res_date
	where room_id=@room_id
end
GO

--tb_room������  ����ȡ��Ԥ������״̬  
CREATE TRIGGER delReserve ON dbo.tb_room_reserve FOR DELETE
AS
BEGIN
	DECLARE @room_id VARCHAR(30);
	SELECT @room_id = room_id FROM Deleted;
	UPDATE dbo.tb_room
	SET room_stat='��'
	WHERE room_id = @room_id
END
GO


--tb_room������  ���·���״̬
CREATE TRIGGER check_room ON dbo.tb_room_check FOR INSERT
AS
BEGIN
	DECLARE @room_id VARCHAR(30);
	SELECT @room_id = room_id FROM Inserted;
	UPDATE dbo.tb_room
	SET room_stat='��'
	WHERE room_id = @room_id
END
GO

--tb_room_check������  ����ǰʱ���Զ�д�����
create trigger check_time on dbo.tb_room_check for insert
as
begin
	declare @room_id varchar(30),@res_date varchar(50)
	select @res_date=GETDATE();
	select @room_id=room_id from inserted;
	update dbo.tb_room_check
	set check_time=@res_date
	where room_id=@room_id
end
GO

--����ɾ����ԤԼ������ֶ�ɾ��
CREATE TRIGGER trg_room ON tb_room
INSTEAD OF DELETE AS
DELETE tb_room_reserve WHERE room_id=(SELECT room_id FROM deleted)
go


--����Ԥ�������
Alter Table tb_room_reserve
Add constraint FK_roomreserve_user foreign key (user_account) 
		references dbo.tb_user_information(user_account)
Go

Alter Table tb_room_reserve
Add constraint FK_roomreserve_room foreign key (room_id) 
		references tb_room(room_id)
Go

--������ס�����
Alter Table tb_room_check
Add constraint FK_roomcheck_user foreign key (user_account) 
		references dbo.tb_user_information(user_account)
Go

Alter Table tb_room_check
Add constraint FK_roomcheck_room foreign key (room_id) 
		references tb_room(room_id)
GO


INSERT dbo.tb_adminer
(
    admin_name,
    admin_pwd,
    admin_gender,
    admin_join,
    admin_type
)
VALUES
( 
    'asdf', -- admin_name - varchar(30)
    '123456', -- admin_pwd - varchar(30)
    '1', -- admin_gender - char(1)
    '2018-09-06 10:16:34', -- admin_join - varchar(30)
    'admin'  -- admin_type - varchar(30)
    )
INSERT dbo.tb_room
(
    room_price,
    room_bednum,
    room_stat
)
VALUES
(   '400', -- room_price - varchar(30)
    '2', -- room_bednumber - varchar(30)
    '��'  -- room_stat - varchar(30)
    )

	INSERT dbo.tb_room_check
	(
	    user_account,
	    room_id,
	    check_time
	)
	VALUES
	(   '1001', -- user_account - varchar(30)
	    '10000',  -- room_id - int
	    '123456'  -- check_time - varchar(30)
	    )


INSERT dbo.tb_user_information
(
    user_account,
    user_pwd,
    user_sfz,
    user_name,
    user_sex,
    user_age,
    user_tel
)
VALUES
(   '1001', -- user_account - varchar(30)
    '123456', -- user_pwd - varchar(30)
    '3303', -- user_sfz - varchar(30)
    '����', -- user_name - varchar(30)
    '��', -- user_sex - varchar(4)
    '16', -- user_age - varchar(4)
    '123456'  -- user_tel - varchar(30)
    )



--shiroȨ��
----------------------------------------------------------------------------------------------------


CREATE Table tb_role								--��ɫ��
(
	role_id varchar(20) not null primary key,			--��ɫ���
	role_name varchar(30) not null,						--��ɫ
	role_description varchar(30) not null,				--��ɫ����
) 

insert tb_role values('1','role:admin','����Ա')
insert tb_role values('2','role:employee','Ա��')

CREATE TABLE tb_user_role
(
	id INT identity(1,1) NOT NULL PRIMARY KEY,
	user_account varchar(30) not NULL,
	role_id VARCHAR(30) NOT NULL
)

insert tb_user_role values('202000','1')
insert tb_user_role values('202001','2')

CREATE TABLE tb_permission
(
	permission_id VARCHAR(5) NOT NULL PRIMARY KEY,
	permission_name VARCHAR(30) NOT NULL,
	permission_type VARCHAR(20) NOT NULL,
	permission_code VARCHAR(30) NOT NULL
)

insert tb_permission values('1','��ס��������','button','admin:checkorder')
insert tb_permission values('2','�������','button','admin:room')
insert tb_permission values('3','Ա������','button','admin:emp')
insert tb_permission values('4','ԤԼ��������','button','admin:resorder')
insert tb_permission values('5','�û�����','button','admin:user')
insert tb_permission values('6','���ݼ��','button','admin:data')

CREATE TABLE tb_role_permission
(
	id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	role_id VARCHAR(20) NOT NULL,
	permission_id VARCHAR(5) NOT NULL
)
insert tb_role_permission values('1','1')
insert tb_role_permission values('1','2')
insert tb_role_permission values('1','3')
insert tb_role_permission values('1','4')
insert tb_role_permission values('1','5')
insert tb_role_permission values('1','6')
insert tb_role_permission values('2','1')
insert tb_role_permission values('2','2')
insert tb_role_permission values('2','4')
insert tb_role_permission values('2','5')

SELECT dbo.tb_permission.* FROM dbo.tb_permission 
INNER JOIN dbo.tb_role_permission ON tb_role_permission.permission_id = tb_permission.permission_id 
INNER JOIN dbo.tb_user_role ON tb_user_role.role_id = tb_role_permission.role_id
WHERE dbo.tb_user_role.user_account =202000
ORDER BY dbo.tb_permission.permission_id
GO



--tb_user_role������   ���Ա��������ɫ
CREATE TRIGGER trg_userRole ON dbo.tb_adminer FOR INSERT
AS
BEGIN
	BEGIN
	INSERT INTO dbo.tb_user_role(user_account,role_id)
	SELECT Inserted.admin_account,'2' FROM Inserted;
	END
END
GO

