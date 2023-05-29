function navigate(path) {
	// window.history.pushState({}, null, path)
	// document.dispatchEvent(new Event('navigation'));
	// console.log('navigate to', path);
	// window.location.pathname = '/' + path;
	const message = "Registration successful! Please login.";
	const url = new URL(window.location.href);
	url.pathname = "/" + path;
	url.searchParams.set("message", message);
	window.location.href = url.toString();
}

export { navigate };
