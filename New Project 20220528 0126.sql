-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema inventory
--

CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

--
-- Definition of table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `cnic` varchar(30) NOT NULL default '',
  `name` varchar(30) default NULL,
  `deposite` double(10,0) default NULL,
  `acc_no` varchar(50) default NULL,
  `card` varchar(80) default NULL,
  `pin` int(20) default NULL,
  `acc_type` varchar(30) default NULL,
  `Date` varchar(20) default NULL,
  PRIMARY KEY  (`cnic`),
  UNIQUE KEY `cnic` (`cnic`),
  UNIQUE KEY `acc_no` (`acc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`cnic`,`name`,`deposite`,`acc_no`,`card`,`pin`,`acc_type`,`Date`) VALUES 
 ('1234567890100','Nur Islam',3000,'PK00COMSATSO706803939370','9363 6443 3005 9337',6064,NULL,'2022-05-23'),
 ('1234567890102','Rajib',0,'PK00COMSATSO460546185336','4898 8567 8931 5181',1524,'Savings account',NULL),
 ('1234567890121','Shahid Ullah',500,'PK00COMSATSO225023468569','6552 5743 2627 2640',4045,NULL,'2022-05-24'),
 ('1234567890125','Abdur Razzak',5000,'PK00COMSATSO254230815763','7866 9453 2429 8613',3050,'Savings account',NULL),
 ('1234567890127','Rana',3000,'PK00COMSATSO672596244383','7375 6479 3645 7090',1284,NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(10) NOT NULL,
  `first_name` varchar(30) default NULL,
  `last_name` varchar(30) default NULL,
  `mobile` varchar(30) default NULL,
  `password` varchar(50) default NULL,
  `NID` varchar(30) default NULL,
  `email` varchar(50) default NULL,
  `address` varchar(80) default NULL,
  `Date` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`id`,`first_name`,`last_name`,`mobile`,`password`,`NID`,`email`,`address`,`Date`) VALUES 
 (1001,'Arafat','Rimon','0185555455','123456','199675458822','arafatrimon25@gmail.com','Dhaka','2022-05-24'),
 (1002,'Nur Islam','Rajib','0183827273782','123456','199675342625267','info.nurislamrajib@gmail.com','Green Road','2022-05-24'),
 (1003,'Nur Islam','Rajib','0183827273782','123456','199675342625267','info.nurislamrajib@gmail.com','Green Road','2022-05-24');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `myimage`
--

DROP TABLE IF EXISTS `myimage`;
CREATE TABLE `myimage` (
  `picid` int(10) default NULL,
  `pic` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `myimage`
--

/*!40000 ALTER TABLE `myimage` DISABLE KEYS */;
INSERT INTO `myimage` (`picid`,`pic`) VALUES 
 (1,0xFFD8FFE000104A46494600010101006000600000FFE100224578696600004D4D002A00000008000101120003000000010001000000000000FFDB0043000201010201010202020202020202030503030303030604040305070607070706070708090B0908080A0807070A0D0A0A0B0C0C0C0C07090E0F0D0C0E0B0C0C0CFFDB004301020202030303060303060C0807080C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0CFFC00011080032003C03012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00FB57F67EBDF14FFC15AFC75E38F11788BC69E2AF087C1AF0CEB32687A3F84FC35A849A5DD6AE53E6F36FAE2221C82BB58A2B11962A3017E6C6F10C3FB11F823E25F897C151FC1FF14789B5CF065DFD87586D2FC29AC6B0209B2C3E6995C96C9471B8F0C55B04E2BA4FF820771FB3778FC9E8BE369CFF00E428EB1FE015C7C4AFD8DFF6E1FDA4BC4979F047E2B78BB45F895AD5B4DA3DE7876D2DE48A48A09AF24F34B3CAA36B2DCA6DEE30F9028033CDD7EC667FE6DDFE257FE1B6D73FC68FB57EC67FF46EFF0012BFF0DB6B9FE35F430FF8282F8C07FCDB3FED199FFB07D99FFDB8A0FF00C1417C639FF9367FDA33FF00002CFF00F922803E79FB57EC67FF0046EFF12BFF000DB6B9FE3593E36F881FB0BFC3EF0FC9A9788BE0878DB41D2E3F965BCBFF00006B36D12704E37330E70A4E17278E2BE9C5FF00828378C4FF00CDB3FED19F8E9F67FF00C915F397FC153BC7BF14BF6ECFD946E3C05E17FD9DBE3869DAAC9A8C57C926A9636CB6EE1239536E5673824C83938000E71401D7FED77FB3D6B9FF0004E5F8537DF16BE05F8CBC4DA4699E13960B8D5FC15ABEAD3EA9E1FD46CA596384F9114ECC607532A3614825436086001FB43F66EF8B36BF1E3E05F85BC6B6767269F6DE2AD360D4D2DA53B9ADCC88A593207386C807B800D7867FC15C57CBFF00826F7C551C6E5D1AD94953B812B79660F3DF915DCFFC1338E7F600F847FF0062CDA7FE81401F34FF00C104067F66DF1F7FB5E369C7FE428EAC785FF6D0F8D9F1BFF6A8F8C9E07F0AEB1F047C1FA5FC2FD563B2B797C536773E65FC5249711AED75970CEBF6725F80079A981E95BFE081EBE67ECDBE3E5FFA9DA7FF00D131D6178C3C53F0F7F686FDA8FE2A787FC31FB0FF00847E2F789BC0FAB7D9FC49ABCB75A1585C5CCD2348AB7127DACC6643234128DC19DFF760BE372E403B0FD9B7FE0A07F11BC61AEFED15A3F8BADBC03AB5F7C17D16E750B1BCD12D6686CF519E159BAEE958BC2C635C636B75E6B9EF827FB657ED11F1A3F6663F1321F167ECE7A3D9C3697974FA4DFD85D47A8916DBC328413632DB0ED19E432F35B5FB1E7C7BF857616FF1EB43B2FD9B7C3BF09F52F873A14D378BB48B18F4EB9FED88238E61258CAF0AF9520015D7696788EF35E57F0DA4F87FF16BE0DAFC42F0DFFC13B3C0FAB78323B79EE4EAEBAAF876248E3B7DC266F2E6649FE4D8DFF2CF271C0391900ED7C4FF00F054CF885A3FFC12FBC27F19A0D1BC23FF000977883C4BFD873C2F6537D8A28835C7CEB179BBB791101F7B68F9B8F48FF6C4FDB67F688FD8EFE0349E3CBCF147ECE9E2C896548534DD1EC2EE4B925E377058198613E4C31182370AB7E2DFDAEFE09DB7FC12F7C2BE389BF67EF0CEA1F0FF0054F117F66597821ED2C859595E6E989BA5CC45031D8E77840E77FCC704E7CFBF680D47E1D7ECAFF0C66F197C43FF008274F827C3FE1756111BA9350F0E5FC770CCACCB1F9501959B7AAB7DE4D87386201E403EAAFF0082B8107FE09BBF15D80DBE6E8D6D2601C81BAF2D0F5EF8CE2BBAFF008266FF00C9807C23FF00B166D3FF0040AE1BFE0AE4FE67FC137FE2D3EE6659348B69013D706F6D08E3B704715DCFFC1337FE4C03E11FFD8B369FFA05007CD7FF00040EFF00936CF1F63FE8769FFF0044C75C3FC528BF671D1BF6A9F8A52E8DE2CFDA874BF1A5D6AC4F8B61F87D15FCD68B7419F8630DBBB04DED2ED0C76E77ECE335B5FF0004C2F88BA4FEC2DF10FE217C0DF8A5770F847C5579E249756D0AF7516FB3E99E23B675DAAD6D3BE1771540FB490486C7DE5651EA5E12FD80FE227C30FDA03E267C45F85DF1BB47F0EA7C57D41350BE82E7C230EACA8A8F34912249F6955C2B5C4DF301F30619E99A00E2FF00625D23F67096CBE3CCBE1ED6BE2B6A57979A1CA3E2149E37FB543A94562527F39B0628E4597FD66E24194103A1AF15F02C9FB35E9DF0C059786BC6DFB6B47E0BF266568F4DB3BF3A4EC60C66DC62B430ED3F36FE7039CE2BEAAF809FF04D5D53E1AEAFF1BB57F147C465F13EB9F1BB4B9B4ED42EAD3414D3E3B179965DF3AC7E7386399061720617AF3589F09FFE09DDF1A3E0A7ECFCDF0C7C3FFB40787ED7C1F25ADD5ABDB4DE028E698A5C6EF3479A6EF3CEF6C1ED91401C378C7C39FB2ACBFF0004AEF0ADB5E6B3F1023F83ABE220DA55E40D29D6DB53DF3EE0C0C6463065F9766C000C738AF25F8D31FECBFAF7C3C7B6F893E34FDB465F0882A644F125AEA51E9FC290399AD4286D9BF1B0EEC676F3CD7D21E21FF824426B9FF04FBF0EFC0B8FE20FD9E4F0F6BC75D5D68E92AE93B666FDD183CD042E25FBDBC9CAD37F6A2FF82707C64FDB13E0EBF817C79FB4168377E1B3224EB1DA780A2B59627446456DE2EF9C2BB70782719A00EEFF00E0AE641FF8270FC59DBB42FF0063DBECD9F776FDB6D36E33FECE3DEBB8FF008266FF00CA3FFE11FF00D8B369FF00A057837FC15CFF00697F0A6B1FB38EB5F077C2FA8278CBE267C42FB2691A5E81A1C82FAEA255B88649279FCA2446A1206001E4BB28C04DEEBF4F7EC61F0BB53F81DFB2AF80BC1DABBC4756F0DE8B6D637BF67903462658D77804E33827191C1C50049F1AFE14F85FE2FF00C2CD62C3C5BE1BD03C51636E998ADF57D3E1BE8A324F3B56556033EC2BF0F7E36F8534BF0B7C4FD52C34BD374FD36C6DE6758ADAD6DD2186319E8AAA001F80A28A00E563B4880FF551FF00DF22A54B48B6FF00AB8FAFF745145002FD922FF9E51FFDF22A7D274CB6BBD5208E5B78248DE50ACAF186561E845145007ED2FEC39F027C0FF0ABE0A43A9785FC1BE15F0DEA17689E7DD697A4DBD9CD36E54CEE78D159B3939C9E6BDDB41FF8F697FEBA9FE9451401FFD9),
 (1,0xFFD8FFE000104A46494600010101006000600000FFE100224578696600004D4D002A00000008000101120003000000010001000000000000FFDB0043000201010201010202020202020202030503030303030604040305070607070706070708090B0908080A0807070A0D0A0A0B0C0C0C0C07090E0F0D0C0E0B0C0C0CFFDB004301020202030303060303060C0807080C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0CFFC00011080032003C03012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00FB57F67EBDF14FFC15AFC75E38F11788BC69E2AF087C1AF0CEB32687A3F84FC35A849A5DD6AE53E6F36FAE2221C82BB58A2B11962A3017E6C6F10C3FB11F823E25F897C151FC1FF14789B5CF065DFD87586D2FC29AC6B0209B2C3E6995C96C9471B8F0C55B04E2BA4FF820771FB3778FC9E8BE369CFF00E428EB1FE015C7C4AFD8DFF6E1FDA4BC4979F047E2B78BB45F895AD5B4DA3DE7876D2DE48A48A09AF24F34B3CAA36B2DCA6DEE30F9028033CDD7EC667FE6DDFE257FE1B6D73FC68FB57EC67FF46EFF0012BFF0DB6B9FE35F430FF8282F8C07FCDB3FED199FFB07D99FFDB8A0FF00C1417C639FF9367FDA33FF00002CFF00F922803E79FB57EC67FF0046EFF12BFF000DB6B9FE3593E36F881FB0BFC3EF0FC9A9788BE0878DB41D2E3F965BCBFF00006B36D12704E37330E70A4E17278E2BE9C5FF00828378C4FF00CDB3FED19F8E9F67FF00C915F397FC153BC7BF14BF6ECFD946E3C05E17FD9DBE3869DAAC9A8C57C926A9636CB6EE1239536E5673824C83938000E71401D7FED77FB3D6B9FF0004E5F8537DF16BE05F8CBC4DA4699E13960B8D5FC15ABEAD3EA9E1FD46CA596384F9114ECC607532A3614825436086001FB43F66EF8B36BF1E3E05F85BC6B6767269F6DE2AD360D4D2DA53B9ADCC88A593207386C807B800D7867FC15C57CBFF00826F7C551C6E5D1AD94953B812B79660F3DF915DCFFC1338E7F600F847FF0062CDA7FE81401F34FF00C104067F66DF1F7FB5E369C7FE428EAC785FF6D0F8D9F1BFF6A8F8C9E07F0AEB1F047C1FA5FC2FD563B2B797C536773E65FC5249711AED75970CEBF6725F80079A981E95BFE081EBE67ECDBE3E5FFA9DA7FF00D131D6178C3C53F0F7F686FDA8FE2A787FC31FB0FF00847E2F789BC0FAB7D9FC49ABCB75A1585C5CCD2348AB7127DACC6643234128DC19DFF760BE372E403B0FD9B7FE0A07F11BC61AEFED15A3F8BADBC03AB5F7C17D16E750B1BCD12D6686CF519E159BAEE958BC2C635C636B75E6B9EF827FB657ED11F1A3F6663F1321F167ECE7A3D9C3697974FA4DFD85D47A8916DBC328413632DB0ED19E432F35B5FB1E7C7BF857616FF1EB43B2FD9B7C3BF09F52F873A14D378BB48B18F4EB9FED88238E61258CAF0AF9520015D7696788EF35E57F0DA4F87FF16BE0DAFC42F0DFFC13B3C0FAB78323B79EE4EAEBAAF876248E3B7DC266F2E6649FE4D8DFF2CF271C0391900ED7C4FF00F054CF885A3FFC12FBC27F19A0D1BC23FF000977883C4BFD873C2F6537D8A28835C7CEB179BBB791101F7B68F9B8F48FF6C4FDB67F688FD8EFE0349E3CBCF147ECE9E2C896548534DD1EC2EE4B925E377058198613E4C31182370AB7E2DFDAEFE09DB7FC12F7C2BE389BF67EF0CEA1F0FF0054F117F66597821ED2C859595E6E989BA5CC45031D8E77840E77FCC704E7CFBF680D47E1D7ECAFF0C66F197C43FF008274F827C3FE1756111BA9350F0E5FC770CCACCB1F9501959B7AAB7DE4D87386201E403EAAFF0082B8107FE09BBF15D80DBE6E8D6D2601C81BAF2D0F5EF8CE2BBAFF008266FF00C9807C23FF00B166D3FF0040AE1BFE0AE4FE67FC137FE2D3EE6659348B69013D706F6D08E3B704715DCFFC1337FE4C03E11FFD8B369FFA05007CD7FF00040EFF00936CF1F63FE8769FFF0044C75C3FC528BF671D1BF6A9F8A52E8DE2CFDA874BF1A5D6AC4F8B61F87D15FCD68B7419F8630DBBB04DED2ED0C76E77ECE335B5FF0004C2F88BA4FEC2DF10FE217C0DF8A5770F847C5579E249756D0AF7516FB3E99E23B675DAAD6D3BE1771540FB490486C7DE5651EA5E12FD80FE227C30FDA03E267C45F85DF1BB47F0EA7C57D41350BE82E7C230EACA8A8F34912249F6955C2B5C4DF301F30619E99A00E2FF00625D23F67096CBE3CCBE1ED6BE2B6A57979A1CA3E2149E37FB543A94562527F39B0628E4597FD66E24194103A1AF15F02C9FB35E9DF0C059786BC6DFB6B47E0BF266568F4DB3BF3A4EC60C66DC62B430ED3F36FE7039CE2BEAAF809FF04D5D53E1AEAFF1BB57F147C465F13EB9F1BB4B9B4ED42EAD3414D3E3B179965DF3AC7E7386399061720617AF3589F09FFE09DDF1A3E0A7ECFCDF0C7C3FFB40787ED7C1F25ADD5ABDB4DE028E698A5C6EF3479A6EF3CEF6C1ED91401C378C7C39FB2ACBFF0004AEF0ADB5E6B3F1023F83ABE220DA55E40D29D6DB53DF3EE0C0C6463065F9766C000C738AF25F8D31FECBFAF7C3C7B6F893E34FDB465F0882A644F125AEA51E9FC290399AD4286D9BF1B0EEC676F3CD7D21E21FF824426B9FF04FBF0EFC0B8FE20FD9E4F0F6BC75D5D68E92AE93B666FDD183CD042E25FBDBC9CAD37F6A2FF82707C64FDB13E0EBF817C79FB4168377E1B3224EB1DA780A2B59627446456DE2EF9C2BB70782719A00EEFF00E0AE641FF8270FC59DBB42FF0063DBECD9F776FDB6D36E33FECE3DEBB8FF008266FF00CA3FFE11FF00D8B369FF00A057837FC15CFF00697F0A6B1FB38EB5F077C2FA8278CBE267C42FB2691A5E81A1C82FAEA255B88649279FCA2446A1206001E4BB28C04DEEBF4F7EC61F0BB53F81DFB2AF80BC1DABBC4756F0DE8B6D637BF67903462658D77804E33827191C1C50049F1AFE14F85FE2FF00C2CD62C3C5BE1BD03C51636E998ADF57D3E1BE8A324F3B56556033EC2BF0F7E36F8534BF0B7C4FD52C34BD374FD36C6DE6758ADAD6DD2186319E8AAA001F80A28A00E563B4880FF551FF00DF22A54B48B6FF00AB8FAFF745145002FD922FF9E51FFDF22A7D274CB6BBD5208E5B78248DE50ACAF186561E845145007ED2FEC39F027C0FF0ABE0A43A9785FC1BE15F0DEA17689E7DD697A4DBD9CD36E54CEE78D159B3939C9E6BDDB41FF8F697FEBA9FE9451401FFD9);
/*!40000 ALTER TABLE `myimage` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(25) NOT NULL,
  `stock` int(10) NOT NULL,
  `unit_price` int(7) default NULL,
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`,`product_name`,`stock`,`unit_price`) VALUES 
 (1001,'Testy Salt',60,85),
 (1002,'Dove Shampoo',42,135),
 (1003,'Sunsilk Shampoo',120,115),
 (1004,'Soya Siuce',120,88),
 (1005,'Coconut Oil',45,115),
 (1007,'Soyabin Oil',45,160);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `trainor`
--

DROP TABLE IF EXISTS `trainor`;
CREATE TABLE `trainor` (
  `trainor_id` varchar(50) NOT NULL,
  `trainor_name` varchar(25) NOT NULL,
  `trainor_password` varchar(100) default NULL,
  `trainor_email` varchar(50) default NULL,
  `trainor_address` varchar(50) default NULL,
  `trainor_city` varchar(30) default NULL,
  `trainor_phone` varchar(15) NOT NULL,
  `trainor_tsp` varchar(30) NOT NULL,
  PRIMARY KEY  (`trainor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trainor`
--

/*!40000 ALTER TABLE `trainor` DISABLE KEYS */;
INSERT INTO `trainor` (`trainor_id`,`trainor_name`,`trainor_password`,`trainor_email`,`trainor_address`,`trainor_city`,`trainor_phone`,`trainor_tsp`) VALUES 
 ('1001','Tanvir Mahtab','ài¼ªØØ¿uØåy5Ø','tanvirmahtab25@gmail.com','Keranigonj','Dhaka','0198785556','NCLC'),
 ('1002','Arafat Rimon','ài¼ªØØ¿uØåy5Ø','arafatrimon@gmail.com','Narayngonj','Dhaka','0198568589','Cogent'),
 ('1005','Bashir Uddin Shikhdar','›Ý}ãïí ‰án²<- ',NULL,NULL,NULL,'1234567899','DTCM'),
 ('1006','Bashir Uddin Shikhdar','ayá„ºâßý¯†®Ñ˜s',NULL,NULL,NULL,'1234567899','DTCM'),
 ('1266359','Helal Uddin','','helaluddin@gmail.com','Savar','Dhaka','01948546553','DITC'),
 ('1267693','Juwel Rana','1267693','rana25@gmail.com','Panthopath','Dhaka','01765448552','USSL');
/*!40000 ALTER TABLE `trainor` ENABLE KEYS */;


--
-- Definition of table `trainor1`
--

DROP TABLE IF EXISTS `trainor1`;
CREATE TABLE `trainor1` (
  `trainor_id` int(10) NOT NULL,
  `trainor_name` varchar(30) default NULL,
  `trainor_password` varchar(80) default NULL,
  `trainor_email` varchar(50) default NULL,
  `trainor_address` varchar(90) default NULL,
  `trainor_city` varchar(30) default NULL,
  `trainor_phone` varchar(20) default NULL,
  `trainor_tsp` varchar(20) default NULL,
  PRIMARY KEY  (`trainor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trainor1`
--

/*!40000 ALTER TABLE `trainor1` DISABLE KEYS */;
INSERT INTO `trainor1` (`trainor_id`,`trainor_name`,`trainor_password`,`trainor_email`,`trainor_address`,`trainor_city`,`trainor_phone`,`trainor_tsp`) VALUES 
 (1001,'Shahid Ullah','É‘Ÿ#ñÕaW¹K¨}¸','baharkhan870@gmail.com','Khilgaon','Dhaka','0183693445','DTCM'),
 (1002,'Abdur Razzak','1002','razzak@gmail.com','Polton','Dhaka','01836527871','Cogent');
/*!40000 ALTER TABLE `trainor1` ENABLE KEYS */;


--
-- Definition of table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `Date` varchar(20) NOT NULL,
  `Time` varchar(20) default NULL,
  `acc_no` varchar(50) NOT NULL,
  `amount` double(10,0) default NULL,
  `CreditDebit` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` (`Date`,`Time`,`acc_no`,`amount`,`CreditDebit`) VALUES 
 ('21/05/2022','1:59:11','PK00COMSATSO706803939370',2000,'Debited'),
 ('21/05/2022','2:0:4','PK00COMSATSO225023468569',500,'Withdraw'),
 ('21/05/2022','2:7:9','PK00COMSATSO225023468569',500,'Withdraw'),
 ('21/05/2022','2:8:13','PK00COMSATSO225023468569',500,'Withdraw'),
 ('21/05/2022','2:19:6','PK00COMSATSO706803939370',1000,'Withdraw'),
 ('22/05/2022','12:16:21','PK00COMSATSO706803939370',4000,'Debited'),
 ('22/05/2022','12:16:21','PK00COMSATSO225023468569',4000,'Credited'),
 ('22/05/2022','12:22:59','PK00COMSATSO225023468569',500,'Withdraw'),
 ('22/05/2022','12:24:46','PK00COMSATSO225023468569',500,'Withdraw');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;


--
-- Definition of table `transactionhistory`
--

DROP TABLE IF EXISTS `transactionhistory`;
CREATE TABLE `transactionhistory` (
  `Date` varchar(20) NOT NULL,
  `AccountNumber` varchar(12) NOT NULL,
  `Amount` varchar(100) NOT NULL,
  `CreditDebit` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionhistory`
--

/*!40000 ALTER TABLE `transactionhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionhistory` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(30) default NULL,
  `user_pass` varchar(100) default NULL,
  `user_phone` varchar(30) default NULL,
  `user_address` varchar(50) default NULL,
  `user_designation` varchar(30) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`user_name`,`user_pass`,`user_phone`,`user_address`,`user_designation`) VALUES 
 (10005,'Nesar Uddin','123456','0192356554','Zighatola','Cashier'),
 (12345,'Helal','123456','0183556556','Savar, Dhaka','Cashier'),
 (123456,'Shahid Ullah','123456','01836934445','Khilgaon','Cashier'),
 (126452,'Admin','admin',NULL,NULL,'admin'),
 (1234567,'Arafat Rimon','123456','1234567890','Dhaka','Cashier'),
 (1267628,'Tanvir Mahtab','123456','0187463736',NULL,'Cashier'),
 (1267939,'Bahar','123456','01580632500225','khilgaon',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(10) default NULL,
  `name` varchar(30) default NULL,
  `creation_date` varchar(20) default NULL,
  `login_time` varchar(20) NOT NULL,
  `logout_time` varchar(20) default NULL,
  PRIMARY KEY  (`login_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`user_id`,`name`,`creation_date`,`login_time`,`logout_time`) VALUES 
 (1001,'Arafat Rimon','2022-05-24','2022-05-26 22:7:29','2022-05-28 1:26:7'),
 (1002,'Nur Islam Rajib','2022-05-24','2022-05-26 3:20:50','2022-05-26 3:20:59'),
 (1001,'Arafat Rimon','2022-05-24','2022-05-26 3:4:23','2022-05-28 1:26:7'),
 (1002,'Nur Islam Rajib','2022-05-24','2022-05-26 3:7:5','2022-05-26 3:20:59'),
 (1000,'admin','2022-05-01','2022-05-27 23:49:56','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-27 23:50:55','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-27 23:58:22','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:11:32','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:12:12','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:13:49','2022-05-28 1:25:45'),
 (1001,'Arafat Rimon','2022-05-24','2022-05-28 1:13:6','2022-05-28 1:26:7'),
 (1000,'admin','2022-05-01','2022-05-28 1:15:0','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:16:42','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:18:1','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:19:47','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:23:29','2022-05-28 1:25:45'),
 (1000,'admin','2022-05-01','2022-05-28 1:24:53','2022-05-28 1:25:45'),
 (1001,'Arafat Rimon','2022-05-24','2022-05-28 1:25:50','2022-05-28 1:26:7'),
 (1000,'admin','2022-05-01','2022-05-28 1:9:17','2022-05-28 1:25:45');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
