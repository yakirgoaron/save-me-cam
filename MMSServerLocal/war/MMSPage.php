<?php
//the page that is returned back is not a html page but
//a mms message.So we must set the proper mime type
header("Content-Type: application/vnd.wap.mms-message");
//a mms message doesn't containt the sender number so it has
//to be found by another way. The way I am using here is
//by passing it form the url using ?n=7878.....
$sender = $_GET['n'];
//this variable stores the current date and time
$cdate = date(dmyHis);
//I am creating a variable that is going to be used in file name
//so to avoid dublicate names
$serial = 0;
//trying to crate a name that is not used
$fname = $sender."_".$cdate.$serial.".mms";
//while(file_exists("mms/".$fname)){//if the name is used increment the
//	$serial = $serial +1;          //serial by 1
//	$fname = $sender."_".$cdate.$serial.".mms";
//}
//The right name has been found! so lets creat a file
//$mms = fopen("mms/".$fname, "w");
//The mms message is in the POST data so the only thing we have to do
//is to store the post data to a file
//fwrite($mms, $HTTP_RAW_POST_DATA);
print($sender);
//send response
print(chr(0x8c));
print(chr(0x81));
print(chr(0x98));
//the above hexadecimals mean that the mms has been received
//we have to send then the transaction id. The transaction id
//starts always in the 3rd byte of the mms message and it ends
//with 0. so we read fron the 3rd byte until we find 0
$x = 3;
while(substr($HTTP_RAW_POST_DATA,$x,1)!=0){
	print(substr($HTTP_RAW_POST_DATA,$x,1));
	$x++;
}
//some additional hexadecimals needed
print(chr(0));
print(chr(0x8D));
print(chr(0x90));
print(chr(0x92));
print(chr(128));

header('Location: http://localhost:8888/mmsserverlocalsaveimage', true, 302);
exit();
?>