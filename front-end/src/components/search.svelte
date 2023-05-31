<script>
	import { createEventDispatcher } from 'svelte';

	const dispatch = createEventDispatcher();

	let search = '';

	function handleSearch() {
		console.log('Search com:', search);
		dispatch('search', search);
	}
</script>

<form class="user-list-form" on:submit|preventDefault={handleSearch}>
	<div class="search-input-wrapper">
		<div class="search-icon">
			<svg
				class="search-icon-svg"
				fill="currentColor"
				viewBox="0 0 20 20"
				xmlns="http://www.w3.org/2000/svg"
			>
				<path
					fill-rule="evenodd"
					d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
					clip-rule="evenodd"
				/>
			</svg>
		</div>
		<label for="topbar-search" class="sr-only">Search</label>
		<input
			type="text"
			bind:value={search}
			name="text"
			id="topbar-search"
			class="search-input"
			placeholder="Search"
		/>
	</div>
</form>

<style>
	.user-list-form .search-input {
		width: 100%;
		--tw-bg-opacity: 1;
		background-color: rgb(255 255 255 / var(--tw-bg-opacity));
		border: 1px solid #e5e7eb;

		border-radius: 0.5rem;
		padding: 0.5rem 1rem 0.5rem 2.75rem; /* Adjust the padding to accommodate the icon */
		font-size: 1rem;
		line-height: 1.5rem;
		color: rgb(17 24 39 / var(--tw-text-opacity));
	}

	.user-list-form .sr-only {
		clip: rect(0, 0, 0, 0);
		border-width: 0;
		height: 1px;
		margin: -1px;
		overflow: hidden;
		padding: 0;
		position: absolute;
		white-space: nowrap;
		width: 1px;
	}

	.user-list-form .search-input-wrapper {
		position: relative;
	}

	.user-list-form .search-icon {
		position: absolute;
		top: 50%;
		left: 0.75rem;
		transform: translateY(-50%);
	}

	.user-list-form .search-icon-svg {
		height: 1.25rem;
		width: 1.25rem;
		color: rgb(107 114 128 / var(--tw-text-opacity));
	}
</style>
