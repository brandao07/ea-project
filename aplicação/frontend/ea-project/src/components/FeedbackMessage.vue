<template>
    <div v-if="messages.length" class="feedback-messages">
        <div v-for="(message, index) in messages" :key="index" :class="['alert ', alertClass(message.severity), ' alert-dismissible fade show']" :role="[' alert']">
            {{ message.message }}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"
                @click="removeMessage(index)"><span aria-hidden="true">&times;</span>
            </button>
        </div>
    </div>
</template>

<script>
import FeedbackSeverity from '../models/enums/FeedbackSeverity';
import EventBus from '@/eventBus';

export default {
    name: 'FeedbackMessage',
    data() {
        return {
            messages: [],
        };
    },
    created() {
        EventBus.on('feedback-message', this.addMessage);
    },
    beforeUnmount() {
        EventBus.off('feedback-message', this.addMessage);
    },
    methods: {
        addMessage(message) {
            this.messages.push(message);

            const timeout = message.severity === 'DANGER' ? 10000 : 5000; // 10 seconds for error messages, 5 seconds for others

            setTimeout(() => {
                this.removeMessage(this.messages.indexOf(message));
            }, timeout);
        },
        removeMessage(index) {
            if (index > -1) {
                this.messages.splice(index, 1);
            }
        },
        alertClass(severity) {
            switch (severity) {
                case FeedbackSeverity.SUCCESS:
                    return 'alert-success';
                case FeedbackSeverity.INFO:
                    return 'alert-info';
                case FeedbackSeverity.WARNING:
                    return 'alert-warning';
                case FeedbackSeverity.DANGER:
                    return 'alert-danger';
                default:
                    return 'alert-secondary';
            }
        },
    },
};
</script>

<style scoped>
.feedback-messages {
    position: fixed;
    top: 10px;
    /* Position near the top of the viewport */
    left: 50%;
    transform: translateX(-50%);
    /* Center horizontally */
    display: flex;
    flex-direction: column;
    align-items: center;
    z-index: 1000;
    /* Responsive width */
    max-width: 800px;
    /* Maximum width */
}

.alert {
    padding: 0.75em 1em;
    margin-bottom: 0.5em;
    border-radius: 0.25em;
    width: 100%;
}

.alert-dismissible .close {
    position: absolute;
    top: 0;
    right: 0;
    padding: .75rem 1.25rem;
    color: inherit;
}

button.close {
    padding: 0;
    background-color: transparent;
    border: 0;
    -webkit-appearance: none;
}

.close {
    float: right;
    font-size: 1.5rem;
    font-weight: 700;
    line-height: 1;
    color: #000;
    text-shadow: 0 1px 0 #fff;
    opacity: .5;
}

/* Media queries for different screen sizes */
@media (min-width: 600px) {
    .feedback-messages {
        width: 95%;
        /* Adjust width for larger screens */
    }
}

@media (min-width: 900px) {
    .feedback-messages {
        width: 60%;
        /* Adjust width for even larger screens */
    }
}

@media (min-width: 1200px) {
    .feedback-messages {
        width: 40%;
        /* Adjust width for large screens */
    }
}
</style>