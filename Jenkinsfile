pipeline {
  agent any

  stages {
    stage('Hello') {
      steps {
        echo 'Hello World'
      }
    }
    stage('UI Tests') {
      steps {
        script {
         def approval_value = false
          def input_approve = input message: 'Do you want to execute UI tests?', ok: 'Submit', parameters: [choice(choices: ['YES', 'NO'], description: 'APPROVE this build to execute UI tests ?', name: 'APPROVE_TESTS')], submitterParameter: 'approving_submitter'

          if (input_approve.APPROVE_TESTS == 'YES') {
            approval_value = true
          }
          if (approval_value == true) {
            echo "Job Approved"
          } else {
            exit 1
          }
        }

      }
      when { triggeredBy 'SCMTrigger' }
    }
    stage('World') {
      steps {
        echo 'Hello World'
      }
    }
  }
}
