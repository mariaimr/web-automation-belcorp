pipeline {
  agent any

  stages {
    stage('Hello') {
      steps {
        echo 'Hello World'
          echo "${currentBuild.getBuildCauses()}" //Always returns full Cause
          echo "${currentBuild.getBuildCauses('jenkins.branch.BranchEventCause')}" // Only returns for branch events
          echo "${currentBuild.getBuildCauses('hudson.triggers.SCMTrigger$SCMTriggerCause')}" // Only returns SCM Trigger
          echo "${currentBuild.getBuildCauses('hudson.model.Cause$UserIdCause')}"  // Only returns if user initiates via Jenkins GUI
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
