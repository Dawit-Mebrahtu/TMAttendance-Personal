
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
</head>
<body>
<body>
	<h1>Administrator Panel</h1>

	<form class="md-form" th:object="${fileUploadInfo}"
		action="/upload" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="container">
				<div class="container">
					<p>
						<a class="btn-floating peach-gradient mt-0 float-left"> <i
							class="fas fa-paperclip" aria-hidden="true"></i> File to upload:
							<input type="file" name="file" />
						</a>
					</p>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="container">
				<div class="container">
					<p id="buttons" class="ex1">
						<input id="submit" type="submit" tabindex="5" value="Upload File" />
					</p>
				</div>
			</div>
		</div>
	</form>
</body>
</html>




