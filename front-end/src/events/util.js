import { navigate } from './navigator';

async function checkAuthInLoginPage() {
	console.log('Check auth in login page');
	// Check if user is authenticated
	const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
	if (token) {
		console.log('token: ', token);
		await fetch('http://localhost:8080/auth/check', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ token })
		}).then((res) => {
			console.log('check Response in login page: ', res);
			if (res.status === 200) {
				console.log('User is still logged in');
				navigate('dashboard');
			} else {
				localStorage.removeItem('sessionToken');
			}
		});
	}
}

async function checkAuthInDashboardPage() {
	console.log('Check auth in dashboard page');
	// Check if user is authenticated
	const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
	if (token) {
		// Authenticate the user
		await fetch('http://localhost:8080/auth/check', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ token })
		})
			.then((res) => {
				console.log('check Response: ', res);
				if (res.status === 200) {
					res.text().then((text) => {
						console.log('Dashboard:' + text);
					});
				} else {
					localStorage.removeItem('sessionToken');
					res.text().then((text) => {
						console.log('Dashboard:' + text);
					});
					//navigate('login');
				}
			})
			.catch((err) => {
				console.error('Dashboard Authentication failed: ', err);
			});
	} else {
		navigate('login');
	}
}

async function getOnlineUsers() {
	try {
		const response = await fetch('http://localhost:8080/auth/online', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const users = await response.json();
			return users;
		} else {
			throw new Error('Failed to get online users');
		}
	} catch (error) {
		console.error('Error retrieving online users:', error);
		return [];
	}
}

async function handleLogout() {
	localStorage.removeItem('sessionToken'); // Clear the token from cookie or local storage
	navigate('login'); // Redirect to the login page
}

async function getAllProducts() {
	try {
		const response = await fetch('http://localhost:8080/products/', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const products = await response.json();
			return products;
		} else {
			console.log('Error');
		}
	} catch (error) {
		console.error('Error retrieving products:', error);
		return [];
	}
}

async function getSearchedProduct(query) {
  if(query === '') return [];
	try {
		const response = await fetch('http://localhost:8080/search/' + query, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const search = await response.json();
			return search;
		} else {
			console.log('Error');
			return [];
		}
	} catch (error) {
		console.error('Error retrieving search:', error);
		return [];
	}
}

export {
	checkAuthInLoginPage,
	checkAuthInDashboardPage,
	handleLogout,
	getOnlineUsers,
	getAllProducts,
	getSearchedProduct
};
