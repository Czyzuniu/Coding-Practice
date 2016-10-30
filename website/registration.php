<?php     //start php tag
//include connect.php page for database connection

Include('connect.php');
//if submit is not blanked i.e. it is clicked.
If(isset($_REQUEST['submit'])!='')
{
If($_REQUEST['name']=='' || $_REQUEST['password']=='' || $_REQUEST['email']=='')
{
Echo "please fill the empty field.";
}
Else
{
$sql="insert into useraccounts(username,password,email) values('".$_REQUEST['name']."', '".$_REQUEST['password']."', '".$_REQUEST['email']."')";
$res=mysql_query($sql);
If($res)
{
Echo "Record has been successfully created";
}
Else
{
Echo "There is some problem in inserting record";
}

}
}

?>
