
<body>
	<h1>Administrator Panel</h1>

	<form:form class="md-form" commandName="fileUploadInfo"
		action="/upload" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="container">
				<div class="container">
					<p>
						<a class="btn-floating peach-gradient mt-0 float-left"> <i
							class="fas fa-paperclip" aria-hidden="true"></i> <form:input
								type="file" path="file" />
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
	</form:form>
</body>



<h3>Upload One File:</h3>

<!-- MyUploadForm -->

<form th:object="${myUploadForm}" method="POST" action="">
	Description: <br> <input th:field="*{description}"
		style="width: 300px;" /> <br />
	<br /> File to upload: <input th:field="*{fileDatas}" type="file" /> <br />
	<input type="submit" value="Upload">
</form>

</body>
</html>

