# RestApi_test
This is a menu Driven REST API made using springboot toolkit 4.
We can perform actions given in menu using GET, PUT, POST and DELETE and putting the localhost link in POSTMAN. 

Schema for Mysql table - CREATE TABLE sat_result (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) UNIQUE NOT NULL,
  address VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  pincode VARCHAR(255) NOT NULL,
  sat_score INT NOT NULL,
  passed INT NOT NULL
);
