CREATE DATABASE finalexam3;

USE finalexam3;

CREATE TABLE	classroom
	(
		id				INT				PRIMARY KEY AUTO_INCREMENT,
        className		NVARCHAR(255)
	);

CREATE TABLE	student
	(
		id				INT				PRIMARY KEY AUTO_INCREMENT,
        name			NVARCHAR(255),
        dateOfBirth		DATE,
        address			NVARCHAR(255),
        phone			NVARCHAR(255),
        email			NVARCHAR(255),
        classroom_id	INT,
        FOREIGN KEY		(classroom_id)	REFERENCES classroom	(id)
	);

INSERT INTO		classroom (className)	VALUES
				('C0522G1'),
				('C0622I1'),
				('C0722H1'),
				('C0822K1'),
				('C0522L1');
                
INSERT INTO		student	(name, dateOfBirth, address, phone, email, classroom_id)	VALUES
				('Phong', '1999-05-16', 'Quảng Ninh', '011111', 'phong@gmail.com', 1),
				('Lương', '1997-1-1', 'Bắc Ninh', '022222', 'luong@gmail.com', 2),
				('Huy', '1999-2-2', 'Thái Bình', '033333', 'huy@gmail.com', 3),
				('Bảnh', '1998-3-3', 'Mê Linh', '044444', 'banh@gmail.com', 4),
				('Linh', '1997-04-4', 'Hà Nội', '055555', 'linh@gmail.com', 5);

SELECT student.id,name,dateOfBirth,address, phone, email, classroom.className FROM STUDENT join classroom on classroom.id=student.classroom_id where student.name like '%?%';

                