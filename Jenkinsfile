node {

  job('Run only when PR is open'){
	 scm {
        git {
            remote {
                github('mariaimr/web-automation-belcorp')
                refspec('+refs/pull/*:refs/remotes/origin/pr/*')
            }
            branch('*/main')
        }
    }
	triggers {
        githubPullRequest {
            admin('mariaimr')
           // admins(['user_2', 'user_3'])
           // userWhitelist('you@you.com')
           // userWhitelist(['me@me.com', 'they@they.com'])
           // orgWhitelist('my_github_org')
           // orgWhitelist(['your_github_org', 'another_org'])
           // cron('H/5 * * * *')
           // triggerPhrase('OK to test')
           // onlyTriggerPhrase()
            useGitHubHooks()
            permitAll()
           // autoCloseFailedPullRequests()
           // allowMembersOfWhitelistedOrgsAsAdmin()
            extensions {
                commitStatus {
                    context('deploy to staging site')
                    triggeredStatus('starting deployment to staging site...')
                    startedStatus('deploying to staging site...')
                    statusUrl('http://mystatussite.com/prs')                    
                    completedStatus('SUCCESS', 'All is well')//
                    completedStatus('FAILURE', 'Something went wrong. Investigate!')
                    completedStatus('PENDING', 'still in progress...')
                    completedStatus('ERROR', 'Something went really wrong. Investigate!')
                }
            }
        }
    }
 }
    stage('Hello') {
        echo 'Hello'
          echo "${currentBuild.getBuildCauses()}" //Always returns full Cause
          echo "${currentBuild.getBuildCauses('jenkins.branch.BranchEventCause')}" // Only returns for branch events
          echo "${currentBuild.getBuildCauses('hudson.triggers.SCMTrigger$SCMTriggerCause')}" // Only returns SCM Trigger
          echo "${currentBuild.getBuildCauses('hudson.model.Cause$UserIdCause')}"  // Only returns if user initiates via Jenkins GUI
    }
    stage('UI Tests') {
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
    stage('World') {
        echo 'World'
    }
  }
