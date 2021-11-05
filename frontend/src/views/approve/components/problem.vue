<template>
  <div>
    {{ prob.description }}
    {{ prob.user }}
    <button @click="sendAccept">승인</button>
    <button @click="sendRevoke">거절</button>
  </div>
</template>

<script>
export default {
  props: {
    prob: {
      type: Array,
    },
  },
  setup(props, { emit }) {
    const sendAccept = () => {
      emit("send-accept", {
        id: props.prob.id,
        problemStatus: "accept",
      });
    };

    const sendRevoke = () => {
      emit("send-revoke", {
        id: props.prob.id,
        problemStatus: "revoke",
      });
    };

    return {
      sendAccept,
      sendRevoke,
    };
  },
};
</script>
