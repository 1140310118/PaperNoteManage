
function delcfm() {
	if (!confirm("确认要删除吗？\n删除的论文将被移动到回收站。")) {
	window.event.returnValue = false;
	}
}
