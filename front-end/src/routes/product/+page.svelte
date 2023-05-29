<script>
	// IMPORTS
	import { onMount } from 'svelte';
	import { getAllProducts } from '../../events/util.js';
	import { getSearchedProduct } from '../../events/util.js';

	let products = [];
	let query = '';
	let search = [];
	let isSearching = false;
	let resultMessage = '';

	onMount(async () => {
		products = await getAllProducts();
		console.log('Products:', products);
	});
	const handleSearch = async () => {
		isSearching = true;
		search = await getSearchedProduct(query);
		console.log('Search:', search);
		if (search.length == 0) {
			resultMessage = 'Result for "' + query + '" not found.';
		} else {
			resultMessage = 'Result for "' + query + '":';
		}
		isSearching = false;
	};
</script>

<div class="bg-green-50 p-2">
	<form class="top-0">
		<label
			for="default-search"
			class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label
		>

		<div class="relative">
			<div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
				<svg
					aria-hidden="true"
					class="w-5 h-5 text-gray-500 dark:text-gray-400"
					fill="none"
					stroke="currentColor"
					viewBox="0 0 24 24"
					xmlns="http://www.w3.org/2000/svg"
					><path
						stroke-linecap="round"
						stroke-linejoin="round"
						stroke-width="2"
						d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
					/></svg
				>
			</div>
			<input
				bind:value={query}
				name="query"
				type="search"
				id="search"
				class="block w-full p-4 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
				placeholder="Search Products..."
				required
			/>
			<button
				on:click={handleSearch}
				disabled={isSearching}
				type="submit"
				class="text-white absolute right-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
				>Search</button
			>
		</div>
	</form>

	<!-- <div id="product">product</div>
    <div id="products">products</div>
    -->

	<!-- Get all products (refresh) 
    <button on:click={getAllProducts} class="bg-blue-100 shadow m-1 p-2 rounded">Refresh</button>
    -->
	{#if isSearching}
		<p>Searching...</p>
	{:else}
		<p>{resultMessage}</p>
		{#if search.length > 0}
			<div class="grid grid-cols-3 gap-3 m-4">
				{#each search as product}
					<!-- Display each product -->
					<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
						{#if product.pName.includes('Iphone')}
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
							<img
								src="https://via.placeholder.com/300x200.png?text={product.pName}"
								alt={product.pName}
							/>
						{/if}
						<p>Name: {product.pName}</p>
						<p>Color: {product.pColor}</p>
						<p>Type: {product.pType}</p>
						<p>Condition: {product.pCondition}</p>
						<p>Price: {product.pPrice} SEK</p>
						<button class="bg-blue-100 shadow m-1 p-2 rounded rounded-sm">Details</button>
					</div>
				{/each}
			</div>
		{/if}
	{/if}

	{#if products.length > 0 && search.length == 0 && query.length == 0}
		<p>Available Products:</p>
		{#if products.length > 0}
			<div class="grid grid-cols-3 gap-3 m-4">
				{#each products as product}
					<!-- Display each product -->
					<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
						{#if product.pName.includes('Iphone')}
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
							<img
								src="https://via.placeholder.com/300x200.png?text={product.pName}"
								alt={product.pName}
							/>
						{/if}
						<p>Name: {product.pName}</p>
						<p>Type: {product.pType}</p>
						<p>Price: {product.pPrice} SEK</p>
						<button class="bg-blue-100 shadow m-1 p-2 rounded rounded-sm">Details</button>
					</div>
				{/each}
			</div>
		{/if}
	{/if}
</div>
