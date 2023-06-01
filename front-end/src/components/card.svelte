<script>
	import { navigateTo } from '../events/navigator';
	import { getUserId } from '../events/util';

	const addToCart = async (pId, pName) => {
		console.log('ADD TO CART', pId, pName);
		// 	"cartId": 5.0,
		//  *     "customerId": 5.0,
		//  *     "orderId": 5.0,
		//  *     "productList": {
		//  *         "productId1": "1",
		//  *         "productId2": "2",
		//  *         "productId3": "1"
		//  *     }
		console.log('Add to cart: ' + pId);
		const email = localStorage.getItem('userEmail');
		const userId = getUserId(email);
		if (userId == null) {
			alert('Please login first');
			return;
		}
		const productId = pId;
		const productList = new Map();
		productList.set(pName, '1');
		const cart = {
			customerId: userId,
			productId: productId,
			productList: productList
		};
		try {
			await fetch('http://localhost:8080/cart/create', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ cart })
			}).then((res) => {
				console.log(res);
				if (res.status === 201) {
					console.log('Added to cart successfully');
					navigateTo('dashboard', "Added to cart successfully");
					// Add a function to give information to user
				}
			});
		} catch (error) {
			console.log('Error creating user:', error);
		}
	};

	export let products;
</script>

<div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(400px, 1fr))">
	{#each products as product}
		<div class="product-card">
			<div class="product-tumb">
				{#if product.pName.includes('iPhone')}
					<img src="./product/iphone.png" alt="" />
				{:else if product.pName.includes('Macbook')}
					<img src="./product/macbook.png" alt="" />
				{:else if product.pName.includes('Ipad')}
					<img src="./product/ipad.png" alt="" />
				{:else if product.pName.includes('Watch')}
					<img src="./product/watch.png" alt="" />
				{:else if product.pName.includes('Airpod')}
					<img src="./product/airpods.png" alt="" />
				{:else}
					<img src="./product/diff.png" alt={product.pName} />
				{/if}
			</div>
			<div class="product-details">
				<span class="product-catagory">{product.pType}</span>
				<h4><a href="">{product.pName}</a></h4>
				<p>{product.pCondition}</p>
				<div class="product-bottom-details">
					<div class="product-price">{product.pPrice} SEK</div>
					<div class="product-links">
						<a href="">
							<img src="https://img.icons8.com/material-outlined/24/000000/visible.png" /></a
						>
						<a href="" on:click={() => addToCart(product.pId, product.pName)}>
							<img
								src="https://img.icons8.com/material-outlined/24/000000/add-shopping-cart.png"
							/></a
						>
					</div>
					<p>Owner: {product.pOwner}</p>
				</div>
			</div>
		</div>
	{/each}
</div>

<style>
	@import url('https://fonts.googleapis.com/css?family=Roboto:400,500,700');
	* {
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}

	body {
		font-family: 'Roboto', sans-serif;
	}
	a {
		text-decoration: none;
	}
	.product-card {
		width: 380px;
		position: relative;
		box-shadow: 0 2px 7px #dfdfdf;
		margin: 50px auto;
		background: #fafafa;
	}

	.badge {
		position: absolute;
		left: 0;
		top: 20px;
		text-transform: uppercase;
		font-size: 13px;
		font-weight: 700;
		background: red;
		color: #fff;
		padding: 3px 10px;
	}

	.product-tumb {
		display: flex;
		align-items: center;
		justify-content: center;
		height: 300px;
		padding: 50px;
		background: #f0f0f0;
	}

	.product-tumb img {
		max-width: 100%;
		max-height: 100%;
	}

	.product-details {
		padding: 30px;
	}

	.product-catagory {
		display: block;
		font-size: 12px;
		font-weight: 700;
		text-transform: uppercase;
		color: #ccc;
		margin-bottom: 18px;
	}

	.product-details h4 a {
		font-weight: 500;
		display: block;
		margin-bottom: 18px;
		text-transform: uppercase;
		color: #363636;
		text-decoration: none;
		transition: 0.3s;
	}

	.product-details h4 a:hover {
		color: #fbb72c;
	}

	.product-details p {
		font-size: 15px;
		line-height: 22px;
		margin-bottom: 18px;
		color: #999;
	}

	.product-bottom-details {
		overflow: hidden;
		border-top: 1px solid #eee;
		padding-top: 20px;
	}

	.product-bottom-details div {
		float: left;
		width: 50%;
	}

	.product-price {
		font-size: 18px;
		color: #fbb72c;
		font-weight: 600;
	}

	.product-price small {
		font-size: 80%;
		font-weight: 400;
		text-decoration: line-through;
		display: inline-block;
		margin-right: 5px;
	}

	.product-links {
		text-align: right;
	}

	.product-links a {
		display: inline-block;
		margin-left: 5px;
		color: #e1e1e1;
		transition: 0.3s;
		font-size: 17px;
	}

	.product-links a:hover {
		color: #fbb72c;
	}
</style>
