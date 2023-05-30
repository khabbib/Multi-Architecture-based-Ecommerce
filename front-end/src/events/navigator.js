function navigateTo(path, message) {
	const url = new URL(window.location.href);
	url.pathname = '/' + path;
	if (message !== null) {
		url.searchParams.set('message', message);
	}
	window.location.href = url.toString();
}

function preInitializePage() {
	const url = new URL(window.location.href);
	const params = url.searchParams;
	if (params.has('message')) {
		const error = params.get('message');
		if (error === "You're not logged in") {
			return {
				status: 'error',
				error
			};
		}

		params.delete('message'); // Remove the message parameter from the URL
		window.history.replaceState({}, '', url.toString()); // Update the URL without the message parameter
		return {
			status: 'success',
			error
		};
	}

	return null;
}

export { navigateTo, preInitializePage };
