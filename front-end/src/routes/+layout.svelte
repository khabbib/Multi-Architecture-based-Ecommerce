<script>
	import '../app.css';
	import Header from '../components/header.svelte';
	import Footer from '../components/footer.svelte';
</script>

<div class="layout">
	<Header />
	<main>
		<slot />
	</main>
	<Footer />
</div>

<style>
	.layout {
		height: 100%;
		max-inline-size: 1440px;
		display: grid;
		grid-template-rows: auto 1fr auto;
		margin-inline: auto;
		padding-inline: 7.5%;
	}

	@media (min-width: 1440px) {
		.layout {
			padding-inline: 0;
		}
	}
</style>
