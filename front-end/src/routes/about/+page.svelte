<script>
	import Table from "../../components/dashboard/table.svelte";
	import Miniheader from "../../components/dashboard/miniheader.svelte";
	import Dashheader from "../../components/dashboard/dashheader.svelte";
	import Model from "../../components/dashboard/model.svelte";
	import Notification from "../../components/dashboard/notification.svelte";
</script>

<div class="bg-green-50">
	<div class="flex items-center justify-center flex-col h-[80vh] gap-10">
		<h1 class="text-4xl font-bold">About us</h1>
	</div>
</div>


<Notification data={"ic"}/>
<Model data={"ic"}/>
<Dashheader data={"ic"}/>
<Miniheader data={"ic"}/>

<Table data={"ic"} />

