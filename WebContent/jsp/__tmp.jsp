<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>HTML5/CSS3简易联系表单DEMO演示</title>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <script src="./read_and_manage_lib/src/jquery.js"></script>
    <link href="./read_and_manage_lib/css/simple.css" rel="stylesheet" type="text/css" media="screen"/> 

</head>

<body>
    <script type="text/javascript">
    $(document).ready(function(){
        $("#button").change(function(){
            $("#filename").val($("#button").val());
        });
    });
    </script>
  <div class="container">  
  <form id="contact" action="" method="post">
    <h3>新建论文</h3>
    <h4>从本地上传</h4>
    <fieldset>
      <input placeholder="*论文名称 nickname" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="论文来源" type="text" tabindex="2" >
    </fieldset>
    
    <fieldset>
        <input type="text" id="filename" placeholder="*" readonly="readonly"
        style="float: left;width: 270px;">
        &nbsp;
        <input type="file" id="button" style="outline: 0px;width:70px;" required>
        

    </fieldset>

    <fieldset>
      <textarea placeholder="备注" id="tmp" tabindex="5" ></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
  </form>

</div>
</body>

</html>