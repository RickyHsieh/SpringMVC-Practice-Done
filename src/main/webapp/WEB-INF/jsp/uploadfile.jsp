<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上傳檔案</title>
</head>
<body>
	<form action="/indexSave" method="POST" enctype="multipart/form-data">
		  <div class="form-group">
		    <label>主旨</label>
		    <input type="text" class="form-control" placeholder="請輸入主旨" name="title">
		  </div>
		  <div class="form-group">
		    <label>內容</label>
		    <textarea rows="20" cols="" class="form-control" placeholder="請輸入內容" name="content"></textarea>
		  </div>
		  <div class="form-group">
		    <label>圖片</label>
		    <input type="file" class="form-control-file" name="newsImage">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
</body>
</html>